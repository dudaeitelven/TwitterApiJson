package principal;

public class Indice {
	
	private String sValor;
	private String sPosicao;
	private long valor;
	private long posicao;
	
	
	public Indice(String sValor, String sPosicao, long valor, long posicao) {
		super();
		this.sValor = sValor;
		this.sPosicao = sPosicao;
		this.valor = valor;
		this.posicao = posicao;
	}


	public String getsValor() {
		return sValor;
	}


	public void setsValor(String sValor) {
		this.sValor = sValor;
	}


	public String getsPosicao() {
		return sPosicao;
	}


	public void setsPosicao(String sPosicao) {
		this.sPosicao = sPosicao;
	}


	public long getValor() {
		return valor;
	}


	public void setValor(long valor) {
		this.valor = valor;
	}


	public long getposicao() {
		return posicao;
	}


	public void setposicao(long posicao) {
		this.posicao = posicao;
	}
	
	
	
	
	
	
	
	

}
