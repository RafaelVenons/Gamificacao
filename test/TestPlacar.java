import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	@Test
	void variosPontos() {
		p.setPontos("guerra", "estrela", 10);
		e.assertEquals("guerra", "estrela", 10);
	}
	
	@Test
	void retornaPontos() {
		p.setPontos("guerra", "estrela", 10);
		p.setPontos("guerra", "moeda");
		Set<String> s = new HashSet<>();
		s.add("Estrela -> 10");
		s.add("Moeda -> 1");
		assertEquals(s, p.getPontosUsuario("guerra"));
	}
	
	@Test
	void retornaRanking() {
		p.setPontos("guerra", "estrela", 25);
		p.setPontos("fernandes", "estrela", 19);
		p.setPontos("rodrigo", "estrela", 17);
		p.setPontos("usuario fora do ranking", "moeda", 50);
		List<String> l = new ArrayList<>();
		l.add("1º - Guerra -> 25");
		l.add("2º - Fernandes -> 19");
		l.add("3º - Rodrigo -> 17");
		assertEquals(l, p.getRanking("estrela"));
	}
}
