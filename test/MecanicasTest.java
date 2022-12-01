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

	@Test
	public void testMecanicaDificilPerdeUmaVida() {
		MecanicaDoJogo mec = FabricaMecanicaDoJogo.getMecanica(2);
		mec.inicializar(() -> {});
		getPalavraMecanica(mec);
		mec.adivinhou("palavra errada");
		assertEquals(mec.getVidas(), -1);
	}

	@Test
	public void testMecanicaFacilTemDuasVidasEPerdeCom3Erros() {
		MecanicaDoJogo mec = FabricaMecanicaDoJogo.getMecanica(1);
		mec.inicializar(() -> {});
		getPalavraMecanica(mec);
		assertEquals(mec.getVidas(), 2);
		mec.adivinhou("palavra errada");
		mec.adivinhou("palavra errada");
		assertEquals(mec.getVidas(), 0);
		mec.adivinhou("palavra errada");
		assertEquals(mec.getStatus(), Status.PERDEU);
	}

	@Test
	public void testMecanicaTreinoNuncaPerde() {
		MecanicaDoJogo mec = FabricaMecanicaDoJogo.getMecanica(3);
		mec.inicializar(() -> {});
		getPalavraMecanica(mec);
		for(int i = 0; i < 100; i++) {
			mec.adivinhou("palavra errada");
		}
		assertEquals(mec.getStatus(), Status.ANDAMENTO);
	}

	@Test
	public void testAcertoIncrementaPontos() {
		MecanicaDoJogo mec = FabricaMecanicaDoJogo.getMecanica(3);
		mec.inicializar(() -> {});
	
		assertEquals(mec.getCorretas(), 0);
		for(int i = 1; i <= 10; i++) {
			getPalavraMecanica(mec);
			tentarTodasPalavrasIniciais(mec);
			assertEquals(mec.getCorretas(), i);
		}
	}

	@Test
	public void testErroIncrementaErradas() {
		MecanicaDoJogo mec = FabricaMecanicaDoJogo.getMecanica(3);
		mec.inicializar(() -> {});
	
		assertEquals(mec.getErradas(), 0);
		
		for(int i = 1; i <= 10; i++) {
			getPalavraMecanica(mec);
			mec.adivinhou("erro");
			assertEquals(mec.getErradas(), i);
		}
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
