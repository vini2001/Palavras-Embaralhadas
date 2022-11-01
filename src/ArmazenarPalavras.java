import java.io.IOException;
import java.util.ArrayList;

public class ArmazenarPalavras {
	public static int qtd;

	public static void armazenar() throws IOException {
		String caminho = Diretorio.dir();
		String arq = String.format("%1$s/%2$s", caminho, "Palavras.txt");
		if (!CustomFileManager.exists(arq)) {
			CustomFileManager.create(arq);

			ArrayList<String> initialWordsSetup = new ArrayList<String>();
			initialWordsSetup.add("Banana");
			initialWordsSetup.add("Batata");
			initialWordsSetup.add("Escola");
			initialWordsSetup.add("Navio");
			initialWordsSetup.add("Paralelepípedo");
			initialWordsSetup.add("Instituto");
			initialWordsSetup.add("Primórdios");
			initialWordsSetup.add("Extase");
			initialWordsSetup.add("Cachorro");
			initialWordsSetup.add("Tomate");
			initialWordsSetup.add("Papai");
			initialWordsSetup.add("Jogo");
			initialWordsSetup.add("Lixeira");
			initialWordsSetup.add("Java");
			initialWordsSetup.add("Aeronáutica");
			initialWordsSetup.add("Programador");
			initialWordsSetup.add("Computador");
			initialWordsSetup.add("Lousa");
			initialWordsSetup.add("Tarefas");
			initialWordsSetup.add("Tubarão");
			initialWordsSetup.add("Lapiseira");
			initialWordsSetup.add("Cadeira");
			initialWordsSetup.add("Madeira");
			initialWordsSetup.add("Mochila");
			initialWordsSetup.add("Cartolina");
			initialWordsSetup.add("Esquilo");
			initialWordsSetup.add("Tabuada");
			initialWordsSetup.add("Espinha");
			initialWordsSetup.add("Pensamento");
			initialWordsSetup.add("Bíceps");
	
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