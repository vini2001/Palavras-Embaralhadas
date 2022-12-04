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

		MecanicaDoJogo facil = FabricaMecanicaDoJogo.getMecanica(1);
		
		facil.inicializar(null);

		assertEquals(FabricaMecanicaDoJogo.getNomeMec(1), "fácil");
	}

	@Test
	public void testQuantidadeVidasaMecanicaFacil() {

		MecanicaDoJogo facil = FabricaMecanicaDoJogo.getMecanica(1);
		
		facil.inicializar(null);

		assertEquals(facil.getVidas(), 2);
	}

	@Test
	public void testMecanicaDificil() {

		MecanicaDoJogo dificil = FabricaMecanicaDoJogo.getMecanica(2);

		dificil.inicializar(null);

		assertEquals(FabricaMecanicaDoJogo.getNomeMec(2), "difícil");
	}

	@Test
	public void testQuantidadeVidasMecanicaDificil() {

		MecanicaDoJogo dificil = FabricaMecanicaDoJogo.getMecanica(2);

		dificil.inicializar(null);

		assertEquals(dificil.getVidas(), 0);
	}

	@Test
	public void testMecanicaTreino() {

		MecanicaDoJogo treino = FabricaMecanicaDoJogo.getMecanica(3);

		treino.inicializar(null);

		assertEquals(FabricaMecanicaDoJogo.getNomeMec(3), "treino");
	}

	@Test
	public void testQuantidadeVidasMecanicaTreino() {

		MecanicaDoJogo treino = FabricaMecanicaDoJogo.getMecanica(3);

		treino.inicializar(null);

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
