package transporteTerrestre;

import java.util.ArrayList;
import java.util.List;

public class EmpresaDeTransporte {
	private List<Camion> camiones;
	private List<Chofer> choferes;
	
	
	public EmpresaDeTransporte() {
		this.camiones = new ArrayList<Camion>();
		this.choferes = new ArrayList<Chofer>();
	}
	public List<Camion> camiones(){
		return this.camiones;
	}
	
	public List<Chofer> choferes(){
		return this.choferes;
	}
	
	public void agregarCamion(Camion camion) {
		this.camiones.add(camion);
	}
	
	public void eliminarCamion(Camion camion) {
		this.camiones.remove(camion);
	}
	
	public void agregarChofer(Chofer chofer) {
		this.choferes.add(chofer);
	}
	
	public void eliminarChofer(Chofer chofer) {
		this.choferes.remove(chofer);
	}
}
