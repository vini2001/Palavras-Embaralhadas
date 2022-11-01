public class EmbaralhadorContrario implements Embaralhador {

	@Override
	public String embaralhar(String word) {
		int tamanho = word.length();
		String resultado = "";
		for (int i = 0; i < tamanho; i++)
			resultado += Character.toString(word.charAt(tamanho - 1 - i));
		return resultado.toLowerCase();
	}
}