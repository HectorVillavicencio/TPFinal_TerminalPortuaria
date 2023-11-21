package ar.edu.unq.po2.tpFinal.BuqueYContainer;

public class Inbound extends FaseDeBuque{

	public Inbound(Buque buque) {
		super(buque);
		// TODO Auto-generated constructor stub
		this.buque.avisoDeArrivo();
	}

	@Override
	public void siguienteFase() {
		// TODO Auto-generated method stub
		this.buque.setFase(new Arrived(this.buque));
	}

	@Override
	public void chequearPosicion(int distanciaDeTerminal) {
		// TODO Auto-generated method stub
		if(distanciaDeTerminal == 0) {
			this.siguienteFase();
		}
	}



}
