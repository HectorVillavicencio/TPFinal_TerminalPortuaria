package Criterio;

import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public class MenorTerminal extends Criterio{
	
	private int terminales;

	public MenorTerminal(int terminales) {
		
		super();
		this.terminales = terminales;
		
	}


	protected boolean condicionBusqueda(Circuito circuito){
			return circuito.getTramos().size()==(terminales);
		}
	

}
