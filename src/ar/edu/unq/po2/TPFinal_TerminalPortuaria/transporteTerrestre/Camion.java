package ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre;

import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;

public class Camion {
	private int id;
	private Chofer chofer;
	private Container carga;
	
	public Camion(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public Container getCarga() {
		return this.carga;
	}

	public Chofer getChofer() {
		return this.chofer;
	}
	
	public void agregarChofer(Chofer chofer) {
		this.chofer = chofer;
	}
	
	public void eliminarChofer() {
		this.chofer = null;
	}
	
	public void cargar(Container container) {
		this.carga = container;
	}
	
	public void descargar() {
		this.carga = null;
	}
	

}

