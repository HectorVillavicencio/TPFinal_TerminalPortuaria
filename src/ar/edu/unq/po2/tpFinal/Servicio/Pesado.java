package ar.edu.unq.po2.tpFinal.Servicio;


public class Pesado implements Servicio{
	private double costoDePesado;
	
	public Pesado(double costoDePesado){
		this.costoDePesado=costoDePesado;
	}
	
	@Override
	public double costo(int horas) {
		
		return costoDePesado;
	}
}