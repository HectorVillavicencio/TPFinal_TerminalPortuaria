package ar.edu.unq.po2.TPFinal_TerminalPortuaria.container;

public class Container {

	private TipoCerrado tipoCerrado ;
	private double ancho;
	private double largo;
	private double altura;
	private double peso;
	private double consumo;
	private TipoContainer tipoContainer;
	
	public Container(TipoCerrado tipoCerrado, double ancho, double largo, double altura, double peso, double consumo,
			TipoContainer tipoContainer) {
		this.tipoCerrado=tipoCerrado;
		this.ancho=ancho;
		this.largo=largo;
		this.altura=altura;
		this.peso=peso;
		this.consumo=consumo;
		this.tipoContainer=tipoContainer;
	}
	
	public double getAncho() {
		return ancho;
	}
	public double getLargo() {
		return largo;
	}
	public double getAltura() {
		return altura;
	}
	public double getPeso() {
		return peso;
	}
	public TipoCerrado getTipoCerrado() {
		return tipoCerrado;
	}

	public TipoContainer getTipoContainer() {
		return tipoContainer;
	}

	public double getConsumo() {
		return consumo;
	}
	public double getMetrosCubicos() {
		//Los metros cúbicos del container.
		return altura * ancho * largo;
	}
	
}


