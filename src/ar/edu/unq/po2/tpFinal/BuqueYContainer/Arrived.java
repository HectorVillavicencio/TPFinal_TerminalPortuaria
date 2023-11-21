package ar.edu.unq.po2.tpFinal.BuqueYContainer;

public class Arrived extends FaseDeBuque{

	public Arrived(Buque buque) {
		super(buque);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void siguienteFase() {
		// TODO Auto-generated method stub
		this.buque.setFase(new Working(this.buque));
	}

	@Override
	public void chequearPosicion(int distanciaDeTerminal) {
		// TODO Auto-generated method stub
		
	}

}
