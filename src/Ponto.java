
public class Ponto implements Comparable<Ponto> {

	private String usuario;
	private String tipo;
	private int pontos;
	
	Ponto(String usuario, String tipo, int ponto){
		super();
		this.usuario = usuario;
		this.tipo = tipo;
		this.pontos = ponto;
	}
	
	@Override
	public int compareTo(Ponto p) {
		if(!this.tipo.equals(p.getTipo()))
			throw new TipeException();
		return p.getPonto() - this.pontos;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public String getTipo() {
		return tipo;
	}
	
	public int getPonto() {
		return pontos;
	}

	@Override
	public String toString() {
		return usuario + " tem " + pontos + " do tipo " + tipo;
	}
}
