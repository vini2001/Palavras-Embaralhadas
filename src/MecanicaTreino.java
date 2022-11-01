public class MecanicaTreino extends BaseMecanica implements MecanicaDoJogo {

	public MecanicaTreino(BancoDePalavras bancoDePalavras) {
		super(bancoDePalavras);
	}

	@Override
	public void acertou() {
		this.corretas++;
		verificarFim();
	}

	public void verificarFim() {
		if (bancoDePalavras.qtd >= ArmazenarPalavras.qtd) {
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
