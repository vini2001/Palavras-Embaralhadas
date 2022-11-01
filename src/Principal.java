import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal {

	boolean finish = false;

	public void iniciar()  throws IOException {
		
		ArmazenarPalavras.armazenar();
		Scanner tec = new Scanner(System.in);

		System.out.println("Bem vindo ao jogo das Palavras embaralhadas!\n");
		int op = 0;

		do {
			opcoes();
			try {
				op = tec.nextInt();
			} catch (InputMismatchException i) {
				op = 0;
				tec.nextLine();
			}
			if (op < 1 || op > 3) {
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nOpção inválida.\n");
			}
		} while (op < 1 || op > 3);

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

	public static void opcoes() {
		System.out.println("Escolha seu modo de jogo: ");
		System.out.println("Modo fácil: Digite 1 para jogar com 2 vidas até zerar o jogo ou perder.");
		System.out.println("Modo difícil: Digite 2 para jogar sem vidas até zerar o jogo ou perder. ");
		System.out.println("Modo treino: Digite 3 para jogar com vidas infinitas, treinando.");
		System.out.print("Opção: ");
	}
}