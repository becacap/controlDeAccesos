package cap.curso.jpa.calendario;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cap.curso.jpa.calendario.servicios.CalendarioServiceInterface;
import cap.curso.jpa.configuracion.Configuracion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuracion.class)
public class CalendarioTest
{

	@Autowired
	private CalendarioServiceInterface calendarioService;

	@Test
	public void calendarioSaveTest()
	{

		Assert.fail();

	}

}
