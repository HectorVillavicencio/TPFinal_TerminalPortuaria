package ar.edu.unq.po2.tpFinal.Servicio;

import ar.edu.unq.po2.tpFinal.orden.Orden;

public class Lavado implements Servicio{
	private double precioFijoExcede;
	private double precioFijo;
	private Orden orden;
	
	public Lavado(double precioFijoExcede, double precioFijo, Orden orden){
		this.precioFijoExcede=precioFijoExcede;
		this.precioFijo=precioFijo;
		this.orden=orden;
	}
	
	
	@Override
	public double costo(int horas) {
		if (orden.getContainer().getMetrosCubicos() > 70) {
			return precioFijoExcede;
		}
			else {
				return precioFijo;
			}
	}
}