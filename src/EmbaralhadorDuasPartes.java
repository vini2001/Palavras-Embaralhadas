import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.List;

public class EmbaralhadorDuasPartes implements Embaralhador {

	Random sorteador = new Random();

	@Override
	public String embaralhar(String word) {

		String resultado = "";

		String parte1 = word.substring(0, word.length() / 2);
		resultado += embaralharParte(parte1);
		String parte2 = word.substring(word.length() / 2);
		resultado += embaralharParte(parte2);

		return resultado;
	}

	private String embaralharParte(String parte) {

		List<String> listaLetras = Arrays.asList(parte.split(""));
		Collections.shuffle(listaLetras);
		String resultado = "";

		for (String letra : listaLetras) {
			resultado += letra;
		}

		return resultado;
	}
}