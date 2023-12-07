package ar.edu.unq.po2.tpFinal.Servicio;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.TipoContainer;
import ar.edu.unq.po2.tpFinal.orden.Orden;

public class Electricidad implements Servicio{
	
	private double costoPorKw;
	private Orden orden;
	
	public Electricidad(double costoPorKw, Orden orden){
		this.costoPorKw=costoPorKw;
		this.orden=orden;
	}
	
	private boolean isTypeReefer(Orden orden) {
		TipoContainer tipoReefer= TipoContainer.Reefer;
		return orden.getContainer().getTipoContainer().equals(tipoReefer);
	}
	
	
	@Override
	public double costo (int cantHoras) {
		double valor=0;
		if(isTypeReefer(orden)) {valor=orden.getContainer().getConsumo() * this.costoPorKw;}
		return valor;
		}
}