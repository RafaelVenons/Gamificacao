import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPonto {

	Ponto p;
	
	@BeforeEach
	void inicializa() {
		p = new Ponto("Guerra", "Estrela", 10);
	}
	
	@Test
	void gets() {
		assertEquals("Guerra", p.getUsuario());
		assertEquals("Estrela", p.getTipo());
		assertEquals(10, p.getPontos());
	}
	
	@Test
	void strings() {
		assertEquals("Guerra tem 10 Estrelas",p.toString());
		assertEquals("1º - Guerra -> 10",p.ranking(1));
		
		Ponto p2 = new Ponto("Paz", "Estrela", 1);
		assertEquals("Paz tem 1 Estrela",p2.toString());
	}
	
	@Test
	void comparar() {
		Ponto p1 = new Ponto("Paz", "Estrela", 10);
		Ponto p2 = new Ponto("Paz", "Estrela", 5);
		Ponto p3 = new Ponto("Paz", "Estrela", 15);
		assertEquals(0,p.compareTo(p1));
		assertEquals(-5,p.compareTo(p2));
		assertEquals(5,p.compareTo(p3));
	}
	
	@Test
	void inicializaUsuarioInvalido() {
		try {
			Ponto pe = new Ponto("", "Estrela", 10);
			fail("Aceitou usuario vazio");
		}catch (UserException e) {}
		try {
			Ponto pe = new Ponto("  ", "Estrela", 10);
			fail("Aceitou usuario vazio");
		}catch (UserException e) {}
		try {
			Ponto pe = new Ponto(null, "Estrela", 10);
			fail("Aceitou usuario null");
		}catch (UserException e) {}
	}
	
	@Test
	void inicializaTipoInvalido() {
		try {
			Ponto pe = new Ponto("Guerra", "", 10);
			fail("Aceitou tipo vazio");
		}catch (TipeException e) {}
		try {
			Ponto pe = new Ponto("Guerra", "  ", 10);
			fail("Aceitou tipo vazio");
		}catch (TipeException e) {}
		try {
			Ponto pe = new Ponto("Guerra", null, 10);
			fail("Aceitou tipo vazio");
		}catch (TipeException e) {}
	}
	
	@Test
	void inicializaPontosInvalido() {
		try {
			Ponto pe = new Ponto("Guerra", "Estrela", 0);
			fail("Aceitou ponto nulo");
		}catch (PontosException e) {}
		try {
			Ponto pe = new Ponto("Guerra", "Estrela", -10);
			fail("Aceitou pontos negativos");
		}catch (PontosException e) {}
	}
	
	@Test
	void compararTipoDiferente() {
		Ponto p2 = new Ponto("Paz", "Moeda", 10);
		try {
			p.compareTo(p2);
			fail("Aceitou Comparar Pontos Diferentes!");
		}catch (TipeException e) {}
	}

}
