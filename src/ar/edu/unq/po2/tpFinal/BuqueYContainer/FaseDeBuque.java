package ar.edu.unq.po2.tpFinal.BuqueYContainer;

public abstract class FaseDeBuque {

	protected Buque buque;
	
	public FaseDeBuque(Buque buque) {
		this.buque = buque;
	}
	
	public abstract void siguienteFase();

	public abstract void chequearPosicion(int distanciaDeTerminal);
}
