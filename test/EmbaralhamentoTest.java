import static org.junit.Assert.assertNotEquals;
import org.junit.*;
import junit.framework.TestCase;

public class EmbaralhamentoTest extends TestCase {

	@Test
	public void testEmbaralhadorAleatorio() { // O embaralhamento aqui é feito de forma randomica, logo, o máximo que podemos
											// testar é se retorna uma palvra diferente da original, ou seja,
											// embaralhada
		EmbaralhadorAleatorio emb = new EmbaralhadorAleatorio();
		assertNotEquals(emb.embaralhar("Papai"), "Papai");
	}

	@Test
	public void testEmbaralhadorDuasPartes() { // O embaralhamento aqui é feita de forma randomica, logo, o máximo que podemos
											// testar é se retorna uma palvra diferente da original, ou seja,
											// embaralhada
		EmbaralhadorDuasPartes emb = new EmbaralhadorDuasPartes();
		assertNotEquals(emb.embaralhar("Mamãe"), "Mamãe");
	}

	@Test
	public void testEmbaralhadorContrario() {
		EmbaralhadorContrario emb = new EmbaralhadorContrario();
		assertEquals(emb.embaralhar("MousePad"), "dapesuom");
		assertEquals(emb.embaralhar("Vinícius"), "suicíniv");
	}

}
