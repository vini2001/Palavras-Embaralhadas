import java.io.File;

public class Diretorio {
    public static String dir() {
        String userHome = System.getProperty("user.home");
        String caminho = String.format("%s/Desktop/Palavras", userHome);
        File file = new File(caminho);
        if (!file.exists())
            file.mkdir();
        return caminho;
    }
}
