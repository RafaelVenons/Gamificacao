import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestArmazenamentoError {

	Armazenamento a;
	
	@BeforeEach
	void inicializa() {
		a = new Armazenamento();
	}
	
	@Test
	void usuarioInvalido() {
		try {
			a.setPontos("", "estrela");
			fail("Aceitou usuario vazio");
		}catch(UserException e) {}
	}
	
	@Test
	void usuarioNull() {
		try {
			a.setPontos(null, "estrela");
			fail("Aceitou usuario null");
		}catch(UserException e) {}
	}
	
	@Test
	void tipoInvalido() {
		try {
			a.setPontos("guerra", "");
			fail("Aceitou tipo vazio");
		}catch(TipeException e) {}
	}
	
	@Test
	void tipoNull() {
		try {
			a.setPontos("guerra", null);
			fail("Aceitou tipo null");
		}catch(TipeException e) {}
	}
	
	@Test
	void pontosInvalidos() {
		try {
			a.setPontos("guerra", "estrela", 0);
			fail("Aceitou pontos invalidos");
		}catch(PontosException e) {}
	}

	@Test
	void pontosUsuarioInezistente() {
		a.setPontos("guerra", "estrela");
		try{
			a.getPontos("paz");
			fail("Aceitou usuario invalido");
		}catch (UserException e) {}

		try{
			a.getPontos("");
			fail("Aceitou usuario vazio");
		}catch (UserException e) {}
		
		try{
			a.getPontos(null);
			fail("Aceitou usuario null");
		}catch (UserException e) {}
	}
	
	@Test
	void pontosInezistentes() {
		a.setPontos("guerra", "estrela");
		assertEquals(0, a.getPontos("guerra", "moeda"));
	}
}
