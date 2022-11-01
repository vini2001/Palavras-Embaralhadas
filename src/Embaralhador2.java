import java.util.Random;

public class Embaralhador2 implements Embaralhador {

	@Override
	public String embaralhar(String word) {
		int tamanho = word.length();
		int part1 = tamanho / 2;
		int part2 = tamanho - part1;

		boolean jaSort[] = new boolean[tamanho];
		for (int i = 0; i < tamanho; i++)
			jaSort[i] = false;
		Random sorteador = new Random();
		String resultado = "";
		do {
			for (int i = 0; i < part1; i++) {
				int sort = 0;
				do {
					sort = sorteador.nextInt(part1);
				} while (jaSort[sort]);
				resultado += Character.toString(word.charAt(sort));
				jaSort[sort] = true;
			}
			for (int i = part1; i < tamanho; i++) {
				int sort = 0;
				do {
					sort = sorteador.nextInt(part2) + part1;
				} while (jaSort[sort]);
				resultado += Character.toString(word.charAt(sort));
				jaSort[sort] = true;
			}
		} while (resultado.equals(word));
		return resultado;
	}
}
