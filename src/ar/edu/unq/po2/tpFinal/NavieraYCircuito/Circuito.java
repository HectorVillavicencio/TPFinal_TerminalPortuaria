package ar.edu.unq.po2.tpFinal.NavieraYCircuito;

import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalPortuaria;

public class Circuito {
	private ArrayList<Tramo> tramos;
	
	public Circuito() {
		this.tramos = new ArrayList<>();
	}
	
	public int tiempoTotal(){
		int tiempo = 0; 
		//retorna el tiempo total en horas
		for(Tramo tramo: this.getTramos()) {
			tiempo += tramo.getTiempo();
		}
		return tiempo; 
	}
	
	public float costoTotal() {
		float costo = 0;
		//retorna el tiempo total en horas
		for(Tramo tramo: this.tramos) {
			costo += tramo.getPrecio();
		}	
		return costo;
	}
	
	public TerminalPortuaria terminalInicial() {
		return this.getTramos().get(0).getTerminalInicial();
	}
	
	public TerminalPortuaria terminalFinal() {
		return this.getTramos().get(this.getTramos().size()-1).getTerminalFinal();
	}

	public ArrayList<Tramo> getTramos() {
		return tramos;
	}
	
	public void agregarTramo(Tramo tramo) {
		this.tramos.add(tramo);
	}

	public double precioEntre(TerminalPortuaria terminalOrigen, TerminalPortuaria terminalDestino) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	

}
