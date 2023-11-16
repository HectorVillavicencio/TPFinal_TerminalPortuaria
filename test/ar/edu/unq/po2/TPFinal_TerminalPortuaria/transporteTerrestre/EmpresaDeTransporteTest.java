package ar.edu.unq.po2.TPFinal_TerminalPortuaria.transporteTerrestre;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EmpresaDeTransporteTest {

	private Chofer chofer;
	private EmpresaDeTransporte empresa;
	
	@BeforeEach
	public void setUp() {
		chofer = mock(Chofer.class);
		empresa = new EmpresaDeTransporte(1); 
	}

}