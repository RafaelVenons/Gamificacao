import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
		try {
			a.setPontos("  ", "estrela");
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
			fail("Aceitou ponto nulo");
		}catch(PontosException e) {}
		try {
			a.setPontos("guerra", "estrela", -10);
			fail("Aceitou ponto negativo");
		}catch(PontosException e) {}
	}

	@Test
	void pontosUsuarioInezistente() {
		a.setPontos("guerra", "estrela");
		try{
			a.getTipoPontos("paz");
			fail("Aceitou usuario invalido");
		}catch (UserException e) {}

		try{
			a.getTipoPontos("");
			fail("Aceitou usuario vazio");
		}catch (UserException e) {}
		
		try{
			a.getTipoPontos(null);
			fail("Aceitou usuario null");
		}catch (UserException e) {}
	}
	
	@Test
	void pontosInezistentes() {
		a.setPontos("guerra", "estrela");
		assertEquals(0, a.getPontos("guerra", "moeda"));
	}
	
	@Test
	void usuariosInexistente() {
		Set<String> s = new HashSet<>();
		assertEquals(s, a.getUsuarios());
	}
	
	@Test
	void pontosUsuarioInexistente() {
		a.setPontos("guerra", "estrela");
		try {
			a.getPontos("Paz");
			fail("Aceitou pesquisa de usuario inexistente");
		}catch (UserException e) {}
		try {
			a.getPontos("  ");
			fail("Aceitou pesquisa de usuario vazio");
		}catch (UserException e) {}
		try {
			a.getPontos("");
			fail("Aceitou pesquisa de usuario vazio");
		}catch (UserException e) {}
		try {
			a.getPontos(null);
			fail("Aceitou pesquisa de usuario null");
		}catch (UserException e) {}
	}
	
	@Test
	void usuariosInexistenteEstruturaPontos() {
		a.setPontos("guerra", "estrela");
		try {
			a.getEstruturaPontos("Paz");
			fail("Aceitou pesquisa de usuario inexistente");
		}catch (UserException e) {}
		try {
			a.getEstruturaPontos("  ");
			fail("Aceitou pesquisa de usuario vazio");
		}catch (UserException e) {}
		try {
			a.getEstruturaPontos("");
			fail("Aceitou pesquisa de usuario vazio");
		}catch (UserException e) {}
		try {
			a.getEstruturaPontos(null);
			fail("Aceitou pesquisa de usuario null");
		}catch (UserException e) {}
	}
	
	@Test
	void tipoInexistenteEstrutura() {
		a.setPontos("guerra", "estrela");
		List<Ponto> l = new ArrayList<>();
		assertEquals(l, a.getEstruturaTipo("moeda"));
	}
	
	@Test
	void tipoInvalidoEstrutura() {
		a.setPontos("guerra", "estrela");
		try {
			a.getEstruturaTipo("");
			fail("Aceitou tipo vazio");
		}catch (TipeException e) {}
		try {
			a.getEstruturaTipo("   ");
			fail("Aceitou tipo vazio");
		}catch (TipeException e) {}
		try {
			a.getEstruturaTipo(null);
			fail("Aceitou tipo null");
		}catch (TipeException e) {}
	}
}
