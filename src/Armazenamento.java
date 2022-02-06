import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Armazenamento implements ArmazenamentoInterface {
	
	private Map<String, Map<String, Integer>> lista;
	
	Armazenamento(){
		lista = new HashMap<String, Map<String, Integer>>();
	}
	
	@Override
	public void setPontos(String usuario, String tipo) {
		setPontos(usuario, tipo, 1);
	}

	@Override
	public void setPontos(String usuario, String tipo, int pontos) {
		validacaoDados(usuario, tipo, pontos);
		
		usuario = formata(usuario);
		tipo = formata(tipo);
				
		if(usuarioNovo(usuario)) {
			novoUsuario(usuario, tipo, pontos);
		} else if(possuiPontos(usuario, tipo)) {
			adicionaPontos(usuario, tipo, pontos);
		} else {
			novoPonto(usuario, tipo, pontos);
		}
	}

	@Override
	public Set<String> getTipoPontos(String usuario) {
		validacaoDados(usuario);
		return lista.get(formata(usuario)).keySet();
	}

	@Override
	public Set<String> getPontos(String usuario) {
		validacaoDados(usuario);
		Set<String> set = new HashSet<>();
		lista.get(formata(usuario)).keySet().forEach(ponto -> {
			ponto = ponto + " -> " + getPontos(usuario, ponto);
			set.add(ponto);
		});
		return set;
	}

	@Override
	public int getPontos(String usuario, String tipo) {
		validacaoDados(usuario);
		usuario = formata(usuario);
		tipo = formata(tipo);
		if(lista.get(usuario).containsKey(tipo))
			return lista.get(usuario).get(tipo);
		return 0;
	}

	@Override
	public Set<String> getUsuarios() {
		return lista.keySet();
	}
	
	private void validacaoDados(String usuario) {
		if(usuario == null || usuario.strip() == "" || !lista.containsKey(formata(usuario)))
			throw new UserException();
	}
	
	private void validacaoDados(String usuario, String tipo, int pontos) {
		if(usuario == null || usuario.strip() == "")
			throw new UserException();
		if(tipo == null || tipo == "")
			throw new TipeException();
		if(pontos <= 0)
			throw new PontosException();
	}
	
	private boolean usuarioNovo(String usuario) {
		return !lista.containsKey(usuario);
	}
	
	private boolean possuiPontos(String usuario, String tipo) {
		return lista.get(usuario).containsKey(tipo);
	}
	
	private void novoUsuario(String usuario, String tipo, int pontos) {
		Map<String, Integer> listaPontos = new HashMap<String, Integer>();
		listaPontos.put(tipo, pontos);
		lista.put(usuario, listaPontos);
	}
	
	private void adicionaPontos(String usuario, String tipo, int pontos){
		lista.get(usuario).replace(tipo, lista.get(usuario).get(tipo)+pontos);
	}
	
	private void novoPonto(String usuario, String tipo, int pontos){
		lista.get(usuario).put(tipo, pontos);
	}
	
	private String formata(String original) {
		char c[] = original.strip().toLowerCase().toCharArray();
		c[0] = Character.toUpperCase(c[0]);
		return new String(c);
	}
}
