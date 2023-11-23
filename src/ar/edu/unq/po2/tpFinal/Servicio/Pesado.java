package ar.edu.unq.po2.tpFinal.Servicio;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;

public class Pesado implements Servicio{
	private double precioFijo;
	
	public Pesado(double precioFijo){
		this.precioFijo=precioFijo;
	}
	
	@Override
	public double costo(Container container) {
		
		return precioFijo;
	}
}