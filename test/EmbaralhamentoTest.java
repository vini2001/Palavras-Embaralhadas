import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

import org.junit.*;
import junit.framework.TestCase;

public class EmbaralhamentoTest extends TestCase {

	@Test
	public void testEmbaralhadorAleatorio() { // O embaralhamento aqui é feito de forma randomica, logo, o máximo que podemos
											// testar é se retorna uma palvra diferente da original, ou seja,
											// embaralhada
		EmbaralhadorAleatorio emb = new EmbaralhadorAleatorio();

		for(int i = 0; i < 10; i++) {
			String randomString = "";
			for(int j = 0; j < 10; j++) {
				randomString += (char) (Math.random() * 26 + 'a');
			}
			String embStr = emb.embaralhar(randomString);
			assertNotEquals(embStr, randomString);

			// sort randomString chars
			char[] chars = randomString.toCharArray();
			Arrays.sort(chars);
			String sortedString = new String(chars);

			chars = embStr.toCharArray();
			Arrays.sort(chars);
			String sortedEmbString = new String(chars);

			assertEquals(sortedEmbString, sortedString);
		}
	}

	@Test
	public void testEmbaralhadorDuasPartes() { // O embaralhamento aqui é feita de forma randomica, logo, o máximo que podemos
											// testar é se retorna uma palvra diferente da original, ou seja,
											// embaralhada
		EmbaralhadorDuasPartes emb = new EmbaralhadorDuasPartes();
		for(int i = 0; i < 10; i++) {
			String randomString = "";
			for(int j = 0; j < 10; j++) {
				randomString += (char) (Math.random() * 26 + 'a');
			}
			String embStr = emb.embaralhar(randomString);
			assertNotEquals(embStr, randomString);
		}
	}

	@Test
	public void testEmbaralhadorContrario() {
		EmbaralhadorContrario emb = new EmbaralhadorContrario();
		assertEquals(emb.embaralhar("MousePad"), "dapesuom");
		assertEquals(emb.embaralhar("Vinícius"), "suicíniv");
		assertEquals(emb.embaralhar("Casa"), "asac");
		assertEquals(emb.embaralhar("Tapete"), "etepat");
		assertEquals(emb.embaralhar("Cadeira"), "ariedac");
		assertEquals(emb.embaralhar("Luminária"), "airánimul");
		assertEquals(emb.embaralhar("Computador"), "rodatupmoc");
		assertEquals(emb.embaralhar("Teclado"), "odalcet");
		assertEquals(emb.embaralhar("Mouse"), "esuom");
		assertEquals(emb.embaralhar("Monitor"), "rotinom");
		assertEquals(emb.embaralhar("Notebook"), "koobeton");
		assertEquals(emb.embaralhar("Impressora"), "arosserpmi");
		assertEquals(emb.embaralhar("Cadeado"), "odaedac");
	}

	@Test
	public void testGetEmbaralhadorReturnsValid() {
		for(int i = 0; i < 10; i++) {
			Embaralhador emb = FabricaEmbaralhadores.getEmbaralhador();
			assertTrue(emb instanceof Embaralhador);
		}
	}

	@Test
	public void testFabricaMecanica() {
		MecanicaDoJogo facil = FabricaMecanicaDoJogo.getMecanica(1);
		assertEquals(FabricaMecanicaDoJogo.getNomeMec(1), "fácil");
		assertTrue(facil instanceof MecanicaDoJogo);

		MecanicaDoJogo medio = FabricaMecanicaDoJogo.getMecanica(2);
		assertEquals(FabricaMecanicaDoJogo.getNomeMec(2), "difícil");
		assertTrue(medio instanceof MecanicaDoJogo);

		MecanicaDoJogo dificil = FabricaMecanicaDoJogo.getMecanica(3);
		assertEquals(FabricaMecanicaDoJogo.getNomeMec(3), "treino");
		assertTrue(dificil instanceof MecanicaDoJogo);
	}

	@Test 
	public void testMecanicaVidas() {
		MecanicaDoJogo facil = FabricaMecanicaDoJogo.getMecanica(1);
		facil.inicializar(null);
		assertEquals(facil.getVidas(), 2);

		MecanicaDoJogo dificil = FabricaMecanicaDoJogo.getMecanica(2);
		dificil.inicializar(null);
		assertEquals(dificil.getVidas(), 0);

		MecanicaDoJogo treino = FabricaMecanicaDoJogo.getMecanica(3);
		treino.inicializar(null);
		assertTrue(treino.getVidas() > 1000);
	}

}
