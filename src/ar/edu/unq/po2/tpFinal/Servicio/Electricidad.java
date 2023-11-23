package ar.edu.unq.po2.tpFinal.Servicio;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.TipoContainer;

public class Electricidad implements Servicio{
	
	private double precioFijo;
	
	public Electricidad(double precioFijo){
		this.precioFijo=precioFijo;
	}
	
	private boolean isTypeReefer(Container container) {
		TipoContainer tipoReefer=TipoContainer.Reefer;
		return container.getTipoContainer().equals(tipoReefer);
	}
	
	private double consumoContainer(Container container) {
		return container.getConsumo();
	}
	
	@Override
	public double costo(Container container) {
		double valor=0;
		if (this.isTypeReefer(container)){valor=this.consumoContainer(container)*this.precioFijo;}
		return valor;
	}
}