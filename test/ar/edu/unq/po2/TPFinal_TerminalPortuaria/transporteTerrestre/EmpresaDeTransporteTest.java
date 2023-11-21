package ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EmpresaDeTransporteTest {

	private Chofer chofer1;
	private Chofer chofer2;
	private Chofer chofer3;
	private Camion camion1;
	private Camion camion2;
	private Camion camion3;
	private EmpresaDeTransporte empresa;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		chofer1 = mock(Chofer.class);
		chofer2 = mock(Chofer.class);
		chofer3 = mock(Chofer.class);
		camion1 = mock(Camion.class);
		camion2 = mock(Camion.class);
		camion3 = mock(Camion.class);
		empresa = new EmpresaDeTransporte(1); 
	}
	
	@Test
	public void testAgregarCamionesAEmpresa() {
		empresa.agregarCamion(camion1);
		empresa.agregarCamion(camion2);
		empresa.agregarCamion(camion3);
		assertEquals(empresa.camiones().size(),3);
	}
	
	@Test
	public void testAgregarChoferesAEmpresa() {
		empresa.agregarChofer(chofer1);
		empresa.agregarChofer(chofer2);
		empresa.agregarChofer(chofer3);
		assertEquals(empresa.choferes().size(),3);
	}
}