import java.io.IOException;

public interface MecanicaDoJogo {
	public void acertou();

	public void errou();

	public void verificarFim();

	public void inicializar(Callback onFinish);

	public int getCorretas();

	public int getErradas();

	public int getTotalTentativas();

	public String getPalavraDoEmbaralhador() throws IOException;

	public String removerAcentos(String str);

	public boolean adivinhou(String resp);

	public int getVidas();

	public String msgFim();

	public Status getStatus();
}
