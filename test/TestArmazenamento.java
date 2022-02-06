import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
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
		a.setPontos("guerra", "moeda");
		assertEquals(1, a.getPontos("guerra", "estrela"));
		assertEquals(1, a.getPontos("guerra", "moeda"));
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
		a.setPontos("guerra", "estrela");
		a.setPontos("GUERRA", "ESTRELA  ");
		a.setPontos("gUERRA  ", "eSTRELA");
		assertEquals(4, a.getPontos("guerra", "estrela"));
	}
}
