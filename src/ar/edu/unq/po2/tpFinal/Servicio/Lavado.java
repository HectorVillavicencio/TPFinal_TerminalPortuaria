package ar.edu.unq.po2.tpFinal.Servicio;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;

public class Lavado implements Servicio{
	private double precioFijoExcede;
	private double precioFijo;
	private double metroCubicoLimite;
	
	public Lavado(double precioFijoExcede, double precioFijo, double metroCubicoLimite){
		this.precioFijoExcede=precioFijoExcede;
		this.precioFijo=precioFijo;
		this.metroCubicoLimite=metroCubicoLimite;
	}
	
	public double totalMetroCubico(Container container) {
		return container.getAltura()*container.getAncho()*container.getLargo();
	}
	
	@Override
	public double costo(Container container) {
		if (this.totalMetroCubico(container) > this.metroCubicoLimite){
			return precioFijoExcede;
		}
		else {
			return precioFijo;
		}
	}
}