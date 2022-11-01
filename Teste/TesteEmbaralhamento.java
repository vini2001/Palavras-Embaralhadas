import static org.junit.Assert.*;

import org.junit.Test;

public class TesteEmbaralhamento {

	@Test
	public void TesteEmbaralhamento1() { // O embaralhamento aqui é feito de forma randomica, logo, o máximo que podemos
											// testar é se retorna uma palvra diferente da original, ou seja,
											// embaralhada
		EmbaralhadorAleatorio emb = new EmbaralhadorAleatorio();
		assertNotEquals(emb.embaralhar("Papai"), "Papai");
	}

	@Test
	public void TesteEmbaralhamento2() { // O embaralhamento aqui é feita de forma randomica, logo, o máximo que podemos
											// testar é se retorna uma palvra diferente da original, ou seja,
											// embaralhada
		EmbaralhadorDuasPartes emb = new EmbaralhadorDuasPartes();
		assertNotEquals(emb.embaralhar("Mamãe"), "Mamãe");
	}

	@Test
	public void TesteEmbaralhamento3() {
		EmbaralhadorContrario emb = new EmbaralhadorContrario();
		assertEquals(emb.embaralhar("MousePad"), "daPesuoM");
		assertEquals(emb.embaralhar("Vinícius"), "suicíniV");
	}

}
