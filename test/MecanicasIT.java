import org.junit.*;
import junit.framework.TestCase;

public class MecanicasTest extends TestCase{


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


}