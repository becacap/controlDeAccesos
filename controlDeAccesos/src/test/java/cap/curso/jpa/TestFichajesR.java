package cap.curso.jpa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cap.curso.jpa.configuracion.Configuracion;
import cap.curso.jpa.services.UsuariosEstadoServiceInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuracion.class)
public class TestFichajesR
{

	@Autowired
	private UsuariosEstadoServiceInterface usuariosEstadoService;
	
	@Test
	public void test()
	{
		fail("Not yet implemented");
	}

	public UsuariosEstadoServiceInterface getUsuariosEstadoService() {
		return usuariosEstadoService;
	}

	public void setUsuariosEstadoService(UsuariosEstadoServiceInterface usuariosEstadoService) {
		this.usuariosEstadoService = usuariosEstadoService;
	}

}
