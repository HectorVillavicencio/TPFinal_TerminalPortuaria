package ar.edu.unq.po2.tpFinal.NavieraYCircuito;

import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalGestionada;
import ar.edu.unq.po2.tpFinal.TerminalPortuaria.TerminalPortuaria;

public class Tramo {
	
	private TerminalGestionada terminalInicial;
	private TerminalGestionada terminalFinal;
	private float precio;
	private int tiempo;
	
	public Tramo(TerminalGestionada terminalInicial, TerminalGestionada terminalFinal, float precio, int tiempo) {
		this.terminalInicial = terminalInicial;
		this.terminalFinal = terminalFinal;
		this.precio = precio; 
		this.tiempo = tiempo; 
	}

	public TerminalPortuaria getTerminalInicial() {
		return terminalInicial;
	}

	public TerminalPortuaria getTerminalFinal() {
		return terminalFinal;
	}


	public float getPrecio() {
		return precio;
	}

	public int getTiempo() {
		return tiempo;
	}

	
	
	
	
}