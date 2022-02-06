import java.util.Set;

import org.junit.Assert;

public class MockArmazenamento extends Armazenamento implements ArmazenamentoInterface {

	public void assertEquals(String usuario, String tipo, int pontos) {
		Assert.assertEquals(pontos, getPontos(usuario, tipo));
	}

}
