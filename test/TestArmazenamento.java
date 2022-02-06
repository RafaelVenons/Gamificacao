import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestArmazenamento {

	Armazenamento a;
	
	@BeforeEach
	void inicializa() {
		a = new Armazenamento();
	}
	
	@Test
	void pontoSimples() {
		a.setPontos("guerra", "estrela");
		assertEquals(1, a.getPontos("guerra", "estrela"));
	}

	@Test
	void variosPontos() {
		a.setPontos("guerra", "estrela",10);
		assertEquals(10, a.getPontos("guerra", "estrela"));
	}
	
	@Test
	void pontosSeguidos() {
		a.setPontos("guerra", "estrela");
		a.setPontos("guerra", "estrela",10);
		assertEquals(11, a.getPontos("guerra", "estrela"));
		a.setPontos("guerra", "estrela",10);
		a.setPontos("guerra", "estrela");
		assertEquals(22, a.getPontos("guerra", "estrela"));
	}
	
	@Test
	void pontosDiferentes() {
		a.setPontos("guerra", "estrela");
		a.setPontos("guerra", "moeda",10);
		assertEquals(1, a.getPontos("guerra", "estrela"));
		assertEquals(10, a.getPontos("guerra", "moeda"));
	}
	
	@Test
	void retornaTodosUsuarios() {
		a.setPontos("guerra", "estrela");
		a.setPontos("paz", "estrela");
		Set<String> s = new HashSet<>();
		s.add("Paz");
		s.add("Guerra");
		assertEquals(s, a.getUsuarios());
	}
	
	@Test
	void retornaTiposPontos() {
		a.setPontos("guerra", "estrela");
		a.setPontos("guerra", "moeda");
		Set<String> s = new HashSet<>();
		s.add("Estrela");
		s.add("Moeda");
		assertEquals(s, a.getTipoPontos("guerra"));
	}
	
	@Test
	void retornaPontos() {
		a.setPontos("guerra", "estrela");
		a.setPontos("guerra", "moeda");
		Set<String> s = new HashSet<>();
		s.add("Estrela -> 1");
		s.add("Moeda -> 1");
		assertEquals(s, a.getPontos("guerra"));
	}
	
	@Test
	void noCaseSensitive() {
		a.setPontos("Guerra", "Estrela");
		a.setPontos("guerra  ", "estrela  ");
		a.setPontos("  GUERRA", "  ESTRELA");
		a.setPontos("  gUERRA  ", "  eSTRELA  ");
		assertEquals(4, a.getPontos("guerra", "estrela"));
	}
	
	@Test
	void estruturaPontos() {
		a.setPontos("guerra", "estrela");
		a.setPontos("guerra", "moeda", 10);
		Map<String, Integer> m = new HashMap<>();
		m.put("Estrela", 1);
		m.put("Moeda", 10);
		assertEquals(m, a.getEstruturaPontos("guerra"));
	}
	
	@Test
	void estruturaTipo() {
		a.setPontos("guerra", "estrela");
		a.setPontos("paz", "estrela", 5);
		a.setPontos("guerra", "moeda", 10);
		List<Ponto> l = new ArrayList<>();
		l.add(new Ponto("Guerra", "Estrela", 1));
		l.add(new Ponto("Paz", "Estrela", 5));
		for(Ponto p : a.getEstruturaTipo("estrela")) {
			assertTrue(l.contains(p));
		}
	}
}
