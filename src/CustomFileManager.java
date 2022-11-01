import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomFileManager {

    public static void create(String ArquivoComDiretorio) throws IOException {
        FileWriter arq = new FileWriter(ArquivoComDiretorio, true);
        arq.close();
    }

    public static boolean exists(String ArquivoComDiretorio) throws IOException {
        String caminho = ArquivoComDiretorio.substring(0, ArquivoComDiretorio.lastIndexOf('/'));
        String nome = ArquivoComDiretorio.substring(ArquivoComDiretorio.lastIndexOf('/') + 1,
                ArquivoComDiretorio.length());
        boolean bool = false;
        File pasta = new File(caminho);
        File[] arquivos = pasta.listFiles();
        for (int i = 0; i < arquivos.length; i++) {
            if (arquivos[i].getName().equals(nome)) {
                bool = true;
                return bool;
            }
        }
        return bool;
    }

    public static void deleteLine(String caminho, String nome, int linha, String cat, String valor) throws IOException {
        String Salvar = String.format("%1$s/%2$s", caminho, nome);
        String linhas[] = new String[10000];
        BufferedReader arqui = new BufferedReader(new FileReader(Salvar));
        String ler;
        int aux = 0;
        while ((ler = arqui.readLine()) != null) {
            aux++;
            linhas[aux] = ler;
        }
        arqui.close();
        //////
        File pasta = new File(caminho);
        File[] arquivos = pasta.listFiles();
        for (int i = 0; i < arquivos.length; i++) {
            if (arquivos[i].getName().equals(nome)) {
                arquivos[i].delete();
                break;
            }
        }
        /////
        FileWriter arq = new FileWriter(Salvar, true);
        PrintWriter gravarArq = new PrintWriter(arq);
        String escrever;
        for (int i = 1; i <= aux; i++) {
            if (i == linha) {
                escrever = String.format("%1$s=%2$s", cat, valor);
            } else {
                escrever = linhas[i];
            }
            gravarArq.println(escrever);
        }

        arq.close();
        gravarArq.close();

    }

    public static void stringSet(String ArquivoComDiretorio, String categoria, String valor) throws IOException {
        String caminho = ArquivoComDiretorio.substring(0, ArquivoComDiretorio.lastIndexOf('/'));
        String nome = ArquivoComDiretorio.substring(ArquivoComDiretorio.lastIndexOf('/') + 1,
                ArquivoComDiretorio.length());
        FileWriter arq = new FileWriter(ArquivoComDiretorio, true);
        PrintWriter gravarArq = new PrintWriter(arq);
        BufferedReader arqui = new BufferedReader(new FileReader(ArquivoComDiretorio));
        String ler;
        String escrever = String.format("%1$s=%2$s", categoria, valor);
        int linha = 0;
        boolean createNew = true;
        while ((ler = arqui.readLine()) != null) {
            linha++;
            int aux2 = categoria.length();
            if (ler.length() > aux2) {
                String aux = ler.substring(0, aux2);
                if (aux.equals(categoria)) {
                    arq.close();
                    arqui.close();
                    gravarArq.close();
                    deleteLine(caminho, nome, linha, categoria, valor);
                    createNew = false;
                    break;
                }
            }
        }
        if (createNew) {
            gravarArq.println(escrever);
            arq.close();
            arqui.close();
            gravarArq.close();
        }

    }

    public static String readString(String ArquivoComDiretorio, String categoria) throws IOException {
        BufferedReader arqui = new BufferedReader(new FileReader(ArquivoComDiretorio));
        String ler;
        String retorno = "null";
        while ((ler = arqui.readLine()) != null) {
            int aux2 = categoria.length();
            if (ler.length() >= aux2) {
                String aux = ler.substring(0, aux2);
                if (aux.equals(categoria)) {
                    arqui.close();
                    retorno = ler.substring(aux2 + 1, ler.length());
                    break;
                }
            }
        }
        return retorno;
    }
}