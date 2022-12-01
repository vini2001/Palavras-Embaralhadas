import java.io.File;
import org.junit.*;
import junit.framework.TestCase;

public class DiretorioTest extends TestCase {

	@Test
	public void testDiretorioRetornaValido() { 
		String diretorioPath = Diretorio.dir();
		assertTrue((new File(diretorioPath)).exists());
	}

		
}
