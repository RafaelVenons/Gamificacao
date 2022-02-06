
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

	public Object getRanking(String tipo) {
		List<Ponto> dados =  e.getEstruturaTipo(tipo);
		Collections.sort(dados);
		List<String> lista = new ArrayList<>();
		int i = 1;
		for(Ponto p : dados) {
			lista.add(p.ranking(i++));
		}
		return lista;
	}
	
	
}
