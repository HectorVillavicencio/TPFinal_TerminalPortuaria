package transporteTerrestre;

public class Camion {
	private Chofer chofer;
	
	public void agregarChofer(Chofer chofer) {
		this.chofer = chofer;
	}
	
	public void eliminarChofer() {
		this.chofer = null;
	}
}
