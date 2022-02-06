import java.util.Map;
import java.util.Set;

public interface ArmazenamentoInterface {
	
	void setPontos(String usuario, String tipo);
	
	void setPontos(String usuario, String tipo, int pontos);
	
	Set<String> getTipoPontos(String usuario);
	
	Map<String, Integer> getEstruturaPontos(String usuario);
	
	Set<String> getPontos(String usuario);
	
	int getPontos(String usuario, String tipo);
	
	Set<String> getUsuarios();
}