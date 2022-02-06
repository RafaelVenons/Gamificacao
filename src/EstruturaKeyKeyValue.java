import java.util.Set;

public interface EstruturaKeyKeyValue {
	
	public void setPontos(String usuario, String tipo);
	
	public void setPontos(String usuario, String tipo, int pontos);
	
	public Set<String> getTipoPontos(String usuario);
	
	public Set<String> getPontos(String usuario);
	
	public int getPontos(String usuario, String tipo);
	
	public Set<String> getUsuarios();
}