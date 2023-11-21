package ar.edu.unq.po2.tpFinal.BuqueYContainer;

public class Outbound extends FaseDeBuque{


	public Outbound(Buque buque) {
		super(buque);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void siguienteFase() {
		// TODO Auto-generated method stub
		this.buque.setFase(new Inbound(this.buque));
	}

	@Override
	public void chequearPosicion(int distanciaDeTerminal) {
		// TODO Auto-generated method stub
		if(distanciaDeTerminal <50) {
			this.siguienteFase();
		}
	}
}
