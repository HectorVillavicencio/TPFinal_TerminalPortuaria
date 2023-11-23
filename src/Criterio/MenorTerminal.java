package Criterio;

import java.util.ArrayList;

import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Circuito;
import ar.edu.unq.po2.tpFinal.NavieraYCircuito.Viaje;

public class MenorTerminal extends Criterio{
	


	public MenorTerminal()  {
		
		super();
		
	}


	protected boolean condicionBusqueda(Circuito circuito1, Circuito circuito2){
			return circuito1.getTramos().size() > circuito2.getTramos().size();
		} 
	

}
