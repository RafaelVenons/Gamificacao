import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Armazenamento {
	
	Map<String, Map<String, Integer>> lista;
	
	Armazenamento(){
		lista = new HashMap<String, Map<String, Integer>>();
	}
	
	public void setPontos(String usuario, String tipo) {
		setPontos(usuario, tipo, 1);
	}
	
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
	
	public Set<String> getPontos(String usuario) {
		validacaoDados(usuario);
		usuario = formata(usuario);
		return lista.get(usuario).keySet();
	}
	
	public int getPontos(String usuario, String tipo) {
		usuario = formata(usuario);
		tipo = formata(tipo);
		return lista.get(usuario).get(tipo);
	}
	
	public Set<String> getUsuarios() {
		return lista.keySet();
	}
	
	private void validacaoDados(String usuario) {
		if(usuario == null || usuario == "" || !lista.containsKey(formata(usuario)))
			throw new UserException();
	}
	
	private void validacaoDados(String usuario, String tipo, int pontos) {
		if(usuario == null || usuario == "")
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
