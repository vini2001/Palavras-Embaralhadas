public class FabricaMecanicaDoJogo {
	public static MecanicaDoJogo getMecanica(int op) {

		BancoDePalavras bancoDePalavras = new BancoDePalavras();

		switch (op) {
			case 1: {
				return new MecanicaFacil(bancoDePalavras);
			}
			case 2: {
				return new MecanicaDificil(bancoDePalavras);
			}
			case 3: {
				return new MecanicaTreino(bancoDePalavras);
			}
		}

		return new MecanicaFacil(bancoDePalavras);
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
