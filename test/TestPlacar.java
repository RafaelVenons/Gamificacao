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
	void errorUserException() {
		try {
			p.setPontos("", "estrela");
			fail("Aceitou usuario vazio");
		}catch (UserException e) {}
		try {
			p.setPontos("  ", "estrela");
			fail("Aceitou usuario vazio");
		}catch (UserException e) {}
		try {
			p.setPontos(null, "estrela");
			fail("Aceitou usuario null");
		}catch (UserException e) {}
	}
	
	@Test
	void errorTipeException() {
		try {
			p.setPontos("guerra", "");
			fail("Aceitou tipo vazio");
		}catch (TipeException e) {}
		try {
			p.setPontos("guerra", "  ");
			fail("Aceitou tipo vazio");
		}catch (TipeException e) {}
		try {
			p.setPontos("guerra", null);
			fail("Aceitou tipo null");
		}catch (TipeException e) {}
	}

	@Test
	void errorPontosException() {
		try {
			p.setPontos("guerra", "estrela", 0);
			fail("Aceitou pontos nulos");
		}catch (PontosException e) {}
		try {
			p.setPontos("guerra", "estrela", -10);
			fail("Aceitou pontos negativos");
		}catch (PontosException e) {}
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
