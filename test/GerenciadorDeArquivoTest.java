import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class GerenciadorDeArquivoTest extends TestCase{
    String filePath;
    
    @Before
    public void setUp() throws IOException {
        String caminho = Diretorio.dir();
		filePath = String.format("%1$s/%2$s", caminho, "Teste.txt");
        CustomFileManager.create(filePath);
    }

    @Test
    public void testArquivoCriado() throws IOException {
        assertTrue(CustomFileManager.exists(filePath));
    }

    @Test
    public void testArquivoEscrito() throws IOException {
        CustomFileManager.stringSet(filePath, "label1", "value1");
        assertEquals(CustomFileManager.readString(filePath, "label1"), "value1");
    }   
}
