package ar.edu.unq.po2.tpFinal.BuqueYContainer;

public class Working extends FaseDeBuque{

	public Working(Buque buque) {
		super(buque);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void siguienteFase() {
		// TODO Auto-generated method stub
		this.buque.setFase(new Departing(this.buque));
	}

	@Override
	public void chequearPosicion(int distanciaDeTerminal) {
		// TODO Auto-generated method stub
		
	}

}
