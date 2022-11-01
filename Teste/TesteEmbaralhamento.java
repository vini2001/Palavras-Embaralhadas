import static org.junit.Assert.*;

import org.junit.Test;

public class TesteEmbaralhamento {

	@Test
	public void TesteEmbaralhamento1() { // O embaralhamento aqui é feito de forma randomica, logo, o máximo que podemos
											// testar é se retorna uma palvra diferente da original, ou seja,
											// embaralhada
		Embaralhador1 emb = new Embaralhador1();
		assertNotEquals(emb.embaralhar("Papai"), "Papai");
	}

	@Test
	public void TesteEmbaralhamento2() { // O embaralhamento aqui é feita de forma randomica, logo, o máximo que podemos
											// testar é se retorna uma palvra diferente da original, ou seja,
											// embaralhada
		Embaralhador2 emb = new Embaralhador2();
		assertNotEquals(emb.embaralhar("Mamãe"), "Mamãe");
	}

	@Test
	public void TesteEmbaralhamento3() {
		Embaralhador3 emb = new Embaralhador3();
		assertEquals(emb.embaralhar("MousePad"), "daPesuoM");
		assertEquals(emb.embaralhar("Vinícius"), "suicíniV");
	}

}
