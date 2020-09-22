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
public class TestFichajesM
{

	@Autowired
	private UsuariosEstadoServiceInterface usuariosEstadoService;
	
	@Test
	public void testTodoCorrecto()
	{
		assertNotNull(usuariosEstadoService.getDiasTrabajadosEmpleadoByYearByMes(1, 2019, 2));;
	}
	
	@Test
	public void testMesMal()
	{
		assertNull(usuariosEstadoService.getDiasTrabajadosEmpleadoByYearByMes(1, 2019, 22));;
	}

}
