import java.io.IOException;
import java.util.Random;

public class BancoDePalavras {
	public int qtd;
	private boolean jafoi[] = new boolean[ArmazenarPalavras.qtd + 1];

	public String palavra() throws IOException {
		String caminho = Diretorio.dir();
		String arq = String.format("%1$s/%2$s", caminho, "Palavras.txt");
		String key = "";
		int sort = 0;
		do {
			Random rand = new Random();
			sort = rand.nextInt(ArmazenarPalavras.qtd) + 1;
		} while (jafoi[sort]);
		jafoi[sort] = true;
		key = Integer.toString(sort);
		qtd++;
		String word = CustomFileManager.readString(arq, key);
		return word;
	}
}