public class MecanicaDificil extends BaseMecanica implements MecanicaDoJogo {

	public MecanicaDificil(BancoDePalavras bancoDePalavras) {
		super(bancoDePalavras);
	}

	@Override
	public void acertou() {
		this.corretas++;
		verificarFim();
	}

	public void verificarFim() {
		if (bancoDePalavras.qtd >= ArmazenarPalavras.qtd) {
			this.status = Status.GANHOU;
			onFinish.call();
		}
		if (this.vidas < 0) {
			onFinish.call();
			this.status = Status.PERDEU;
		}
	}

	@Override
	public void errou() {
		this.erradas++;
		this.vidas--;
		verificarFim();
	}

	@Override
	public void inicializar(Callback onFinish) {
		this.vidas = 0;
		super.inicializar(onFinish);
	}
}
