import java.util.Set;

public class Placar {
	private ArmazenamentoInterface e;
	
	Placar(ArmazenamentoInterface e){
		this.e = e;
	}

	public void setPontos(String usuario, String tipo) {
		e.setPontos(usuario, tipo);
	}

	public void setPontos(String usuario, String tipo, int pontos) {
		e.setPontos(usuario, tipo, pontos);
	}

	public Set<String> getPontosUsuario(String usuario) {
		return e.getPontos(usuario);
	}
	
	
}
