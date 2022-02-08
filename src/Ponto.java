
public class Ponto implements Comparable<Ponto> {

	private String usuario;
	private String tipo;
	private int pontos;
	
	Ponto(String usuario, String tipo, int ponto){
		super();
		Armazenamento.validacaoDados(usuario, tipo, ponto);
		this.usuario = usuario;
		this.tipo = tipo;
		this.pontos = ponto;
	}
	
	@Override
	public int compareTo(Ponto p) {
		if(!this.tipo.equals(p.getTipo()))
			throw new TipeException();
		return p.getPontos() - this.pontos;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public String getTipo() {
		return tipo;
	}
	
	public int getPontos() {
		return pontos;
	}

	public String ranking(int i) {
		return i + "º - " + usuario + " -> " + pontos;
	}
	
	@Override
	public String toString() {
		return usuario + " tem " + pontos + " " + tipo + (pontos == 1 ? "" : "s");
	}
	
	@Override
	public boolean equals(Object o) {
		Ponto p = (Ponto) o;
		if(!this.usuario.equals(p.getUsuario())) return false;
		if(!this.tipo.equals(p.getTipo())) return false;
		if(this.pontos != p.getPontos()) return false;
		return true;
	}
}
