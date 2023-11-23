package ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre;
import ar.edu.unq.po2.TPFinal_TerminalPortuaria.container.Container;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CamionTest {

	private Chofer chofer1;
	private Container container;
	private Camion camion1;

	
	@BeforeEach
	public void setUp() throws Exception {
		chofer1 = mock(Chofer.class);
		container = mock(Container.class);
		camion1 = new Camion(1);
	}

	@Test
	public void testAgregarChoferACamion() {
		camion1.agregarChofer(chofer1);
		assertEquals(camion1.getChofer(),chofer1);
	}

	@Test
	public void testAgregarYEliminarChoferACamion() {
		camion1.agregarChofer(chofer1);
		camion1.eliminarChofer();
		assertEquals(camion1.getChofer(),null);
	}
	
	@Test
	public void testCargarCamion() {
		camion1.cargar(container);
		assertEquals(camion1.getCarga(),container);
	}
	
	@Test
	public void testCargaryDescargarCamion() {
		camion1.cargar(container);
		camion1.descargar();
		assertEquals(camion1.getCarga(),null);
	}
	
	@Test
	public void testIdDeChofer() {
		camion1.agregarChofer(new Chofer(1));
		assertEquals(camion1.getChofer().getId(),1);
	}
	
	@Test
	public void testIdDeCamion() {
		assertEquals(camion1.getId(),1);
	}
}
