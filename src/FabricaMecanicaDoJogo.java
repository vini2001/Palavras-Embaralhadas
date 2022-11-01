public class FabricaMecanicaDoJogo {
	public static MecanicaDoJogo getMecanica(int op) {

		BancoDePalavras bancoDePalavras = new BancoDePalavras();

		switch (op) {
			case 1: {
				return new Mecanica1(bancoDePalavras);
			}
			case 2: {
				return new Mecanica2(bancoDePalavras);
			}
			case 3: {
				return new Mecanica3(bancoDePalavras);
			}
		}

		return new Mecanica1(bancoDePalavras);
	}

	public static String getNomeMec(int op) {
		switch (op) {
			case 1: {
				return "fácil";
			}
			case 2: {
				return "difícil";
			}
			case 3: {
				return "treino";
			}
			default: {
				return "fácil";
			}
		}
	}

}
