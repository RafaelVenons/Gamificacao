
public class Placar {
	private ArmazenamentoInterface e;
	
	Placar(ArmazenamentoInterface e){
		this.e = e;
	}

	public void setPontos(String string, String string2) {
		e.setPontos(string, string2);
	}
	
	
}
