import java.io.IOException;
import java.util.ArrayList;

public class ArmazenarPalavras {
	public static int qtd;


	public static String[] palavrasIniciais = {"Banana", "Batata",  "Escola",  "Navio",  "Paralelepipedo",  "Instituto",  "Primordios",  "Extase",  "Cachorro",  "Tomate",  "Papai",  "Jogo",  "Lixeira",  "Java",  "Aeronautica",  "Programador",  "Computador",  "Lousa",  "Tarefas",  "Tubarao",  "Lapiseira",  "Cadeira",  "Madeira",  "Mochila",  "Cartolina",  "Esquilo",  "Tabuada",  "Espinha",  "Pensamento",  "Biceps"};

	public static void armazenar() throws IOException {
		String caminho = Diretorio.dir();
		String arq = String.format("%1$s/%2$s", caminho, "Palavras.txt");
		if (!CustomFileManager.exists(arq)) {
			CustomFileManager.create(arq);

			ArrayList<String> initialWordsSetup = new ArrayList<String>();
			for(int i = 0; i < palavrasIniciais.length; i++) {
				initialWordsSetup.add(palavrasIniciais[i]);
			}
	
			for (int i = 1; i < initialWordsSetup.size(); i++) {
				if (CustomFileManager.readString(arq, String.valueOf(i)).equals("null")) {
					CustomFileManager.stringSet(arq, String.valueOf(i), initialWordsSetup.get(i));
				}
			}	
		}

		int i = 1;
		while (!CustomFileManager.readString(arq, Integer.toString(i)).equals("null")) {
			i++;
		}
		qtd = i - 1;
	}
}