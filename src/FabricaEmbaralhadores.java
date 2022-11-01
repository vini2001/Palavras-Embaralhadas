import java.util.Random;

public class FabricaEmbaralhadores {
	public static Embaralhador getEmbaralhador() {
		Random rand = new Random();
		int valor = rand.nextInt(3);
		switch (valor) {
			case 0: {
				return new Embaralhador1();
			}
			case 1: {
				return new Embaralhador2();
			}
			case 2: {
				return new Embaralhador3();
			}
		}
		return new Embaralhador1();
	}
}
