import java.io.IOException;

import org.junit.*;
import junit.framework.TestCase;

public class MecanicasTest extends TestCase {


	@BeforeClass
	public void setUp() {
		try {
			ArmazenarPalavras.armazenar();
		} catch (IOException e) {
			fail();
		}
	}

	@Test
	public void testFabricaMecanicaFacil() {

		//arrange
		MecanicaDoJogo facil = FabricaMecanicaDoJogo.getMecanica(1);
		
		//act
		facil.inicializar(null);

		//assert
		assertEquals(FabricaMecanicaDoJogo.getNomeMec(1), "fácil");
		assertEquals(facil.getVidas(), 2);
	}

	@Test
	void testFabricaMecanicaDificil() {

		//arrange
		MecanicaDoJogo dificil = FabricaMecanicaDoJogo.getMecanica(2);

		//act
		dificil.inicializar(null);

		//assert
		assertEquals(FabricaMecanicaDoJogo.getNomeMec(2), "difícil");
		assertEquals(dificil.getVidas(), 0);
	}

	@Test
	void testMecanicaTreino() {

		//arrange
		MecanicaDoJogo treino = FabricaMecanicaDoJogo.getMecanica(3);

		//act
		treino.inicializar(null);

		//assert
		assertEquals(FabricaMecanicaDoJogo.getNomeMec(3), "treino");
		assertTrue(treino.getVidas() > 1000);
	}

	@Test
	public void testMecanicaRetornaPalavra(){
		
		MecanicaDoJogo facil = FabricaMecanicaDoJogo.getMecanica(1);
		try {
			facil.inicializar(null);

			String palavra = facil.getPalavraDoEmbaralhador();
			assertTrue(palavra instanceof String);
		}catch(Exception e) {
			fail("Erro ao retornar palavra");
		}
	}

	@Test
	public void testRemoverAcentos() {

		BaseMecanica baseMecanica = new BaseMecanica(new BancoDePalavras());
		String palavra = "árvore";

		String palavraSemAcentos = baseMecanica.removerAcentos(palavra);

		assertEquals("arvore", palavraSemAcentos);

		
	}

	@Test
	public void testPalavraRetornadaPorMecanicaPodeSerDesembaralhadaPorUmaDasPalavrasPadroes() {
		MecanicaDoJogo mec = FabricaMecanicaDoJogo.getMecanica(3);
		mec.inicializar(null);
		getPalavraMecanica(mec);

		boolean adivinhou = tentarTodasPalavrasIniciais(mec);
		assertTrue(adivinhou);
	}

	private String getPalavraMecanica(MecanicaDoJogo mec) {
		try {
			String palavra = mec.getPalavraDoEmbaralhador();
			return palavra;
		}catch(Exception e) {
			fail("Erro ao retornar palavra");
		}
		return null;
	}

	private boolean tentarTodasPalavrasIniciais(MecanicaDoJogo mec) {
		String[] palavrasIniciais = ArmazenarPalavras.palavrasIniciais;

		boolean adivinhou = false;
		for(int i = 0; i < palavrasIniciais.length; i++) {
			if(mec.adivinhou(palavrasIniciais[i])) {
				adivinhou = true;
			}
		}
		return adivinhou;
	}

}
