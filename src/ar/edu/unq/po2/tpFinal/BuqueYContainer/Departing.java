package ar.edu.unq.po2.tpFinal.BuqueYContainer;

public class Departing extends FaseDeBuque{

	public Departing(Buque buque) {
		super(buque);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void siguienteFase() {
		// TODO Auto-generated method stub
		this.buque.setFase(new Outbound(this.buque));
	}

	@Override
	public void chequearPosicion(int distanciaDeTerminal) {
		// TODO Auto-generated method stub
		if(distanciaDeTerminal == 1) {
			this.buque.avisoDePartida();
			this.siguienteFase();
		}
	}

}
