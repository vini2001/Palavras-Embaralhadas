import java.io.IOException;
import java.text.Normalizer;

enum Status {
	INICIO, ANDAMENTO, GANHOU, FIMTREINO, PERDEU
}
public abstract class BaseMecanica {
	Callback onFinish;
	BancoDePalavras bancoDePalavras;
	protected int corretas = 0, erradas = 0, jafoi = 0, vidas = 0;
	protected Status status = Status.INICIO;

	public BaseMecanica(BancoDePalavras bancoDePalavras) {
		this.bancoDePalavras = bancoDePalavras;
	}

	public String msgFim() {
		switch (status) {
			case GANHOU:
				return "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nParabéns, você venceu!\n";
			case PERDEU:
				return "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nQue pena, você perdeu. Tente novamente!\n";
			case FIMTREINO:
				return "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nVocê chegou ao fim de um treino...\n";
			default:
				return "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nIsso não era pra estar aqui.\n";
		}
	}

	public int getCorretas() {
		return this.corretas;
	}

	public int getErradas() {
		return this.erradas;
	}

	public int getTotalTentativas() {
		return this.jafoi;
	}

	public abstract void acertou();

	public abstract void errou();

	public String wordAt;

	public String getPalavraDoEmbaralhador() throws IOException {
		String word = bancoDePalavras.palavra();
		if (word.equals("=Tomate"))
			word = bancoDePalavras.palavra();
		this.wordAt = word;
		Embaralhador emb = FabricaEmbaralhadores.getEmbaralhador();
		this.jafoi++;
		return emb.embaralhar(word).toLowerCase();
	}

	public String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public boolean Adivinhou(String resp) {
		resp = removerAcentos(resp);
		if (resp.toLowerCase().equals(removerAcentos(this.wordAt.toLowerCase()))) {
			this.acertou();
			return true;
		} else {
			this.errou();
			return false;
		}
	}

	public int getVidas() {
		return this.vidas;
	}
}