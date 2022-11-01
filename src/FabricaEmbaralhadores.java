import java.util.Random;

public class FabricaEmbaralhadores {
	public static Embaralhador getEmbaralhador() {
		Random rand = new Random();
		int valor = rand.nextInt(3);
		switch (valor) {
			case 0: {
				return new EmbaralhadorAleatorio();
			}
			case 1: {
				return new EmbaralhadorDuasPartes();
			}
			case 2: {
				return new EmbaralhadorContrario();
			}
		}
		return new EmbaralhadorAleatorio();
	}
}
