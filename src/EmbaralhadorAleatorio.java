import java.util.Random;

public class EmbaralhadorAleatorio implements Embaralhador {

	@Override
	public String embaralhar(String word) {
		int tamanho = word.length();
		boolean jaSort[] = new boolean[tamanho];
		Random sorteador = new Random();
		String resultado = "";
		do {
			for (int i = 0; i < tamanho; i++) {
				int sort = 0;
				do {
					sort = sorteador.nextInt(tamanho);
				} while (jaSort[sort]);
				resultado += Character.toString(word.charAt(sort));
				jaSort[sort] = true;
			}
		} while (resultado.equals(word));
		return resultado;
	}
}