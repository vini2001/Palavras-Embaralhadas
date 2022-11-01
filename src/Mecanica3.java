public class Mecanica3 extends BaseMecanica implements MecanicaDoJogo {

	public Mecanica3(BancoDePalavras bancoDePalavras) {
		super(bancoDePalavras);
	}

	@Override
	public void acertou() {
		this.corretas++;
		verificarFim();
	}

	public void verificarFim() {
		if (bancoDePalavras.qtd >= 20) {
			this.status = Status.FIMTREINO;
			onFinish.call();
		}
	}

	@Override
	public void errou() {
		this.erradas++;
		verificarFim();
	}

	@Override
	public void inicializar(Callback onFinish) {
		this.vidas = 9999;
		this.onFinish = onFinish;
	}
}
