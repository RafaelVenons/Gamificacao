import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPlacar {

	MockArmazenamento e;
	Placar p;
	
	@BeforeEach
	void inicializa() {
		e = new MockArmazenamento();
		p = new Placar(e);
	}
	
	@Test
	void pontoSimples() {
		p.setPontos("guerra", "estrela");
		e.assertEquals("guerra", "estrela", 1);
	}

}
