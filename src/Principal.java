import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal {

	boolean finish = false;

	static Scanner tec = new Scanner(System.in);

	public void iniciar()  throws IOException {
		
		ArmazenarPalavras.armazenar();

		int op = selecionarModoJogo();

		String modo = FabricaMecanicaDoJogo.getNomeMec(op);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nVocê escolheu o modo " + modo + ".");

		MecanicaDoJogo mec = FabricaMecanicaDoJogo.getMecanica(op);

		mec.inicializar(new Callback() {
			@Override
			public void call() {
				finish = true;
			}
		});

		while (!finish) {
			String wordEmb = mec.getPalavraDoEmbaralhador();
			String vidasSt = "";
			if (mec.getVidas() > 9000)
				vidasSt = "∞";
			else
				vidasSt = Integer.toString(mec.getVidas());
			System.out.println("\n\n\n\nStatus: " + mec.getTotalTentativas() + "ª palavra   Vidas: " + vidasSt
					+ "   Acertou: " + mec.getCorretas() + "   Errou: " + mec.getErradas());
			System.out.println();
			System.out.println("Desembaralhe a palavra: " + wordEmb);
			System.out.print("Resposta: ");
			String resp = tec.next();
			calcularResposta(mec, resp);

		}

		encerrarJogo(mec);
	}



	private int selecionarModoJogo(){

		System.out.println("Bem vindo ao jogo das Palavras embaralhadas!\n");
		mostrarOpcoes();

		int op = 0;
		String opString;

		while (op < 1 || op > 3){
			opString = tec.next();
			op = Integer.parseInt(opString);
		}

		return op;
	}


	private static void calcularResposta(MecanicaDoJogo mec, String resp) {

		if (mec.Adivinhou(resp)) {
			System.out.print("\nAcertou!");
			System.out.print(" Digite qualquer coisa para continuar: ");
			tec.next();
		} else {
			System.out.print("\nErrou!");
			System.out.print(" Digite qualquer coisa para continuar: ");
			tec.next();
		}
	}
	
	
	private static void encerrarJogo(MecanicaDoJogo mec) {

		System.out.println(mec.msgFim());
		System.out.println("Jogo encerrado!    Acertou: " + mec.getCorretas() + "   Errou: " + mec.getErradas());
		tec.close();
	}
	
	public static void main(String[] args)  {
		Principal p = new Principal();
		try {
			p.iniciar();
		} catch (IOException e) {
			System.out.println("Erro ao iniciar o jogo.");
		}
	}

	public static void mostrarOpcoes() {
		System.out.println("Escolha seu modo de jogo: ");
		System.out.println("Modo fácil: Digite 1 para jogar com 2 vidas até zerar o jogo ou perder.");
		System.out.println("Modo difícil: Digite 2 para jogar sem vidas até zerar o jogo ou perder. ");
		System.out.println("Modo treino: Digite 3 para jogar com vidas infinitas, treinando.");
		System.out.print("Opção: ");
	}
}