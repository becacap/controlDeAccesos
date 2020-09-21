package cap.curso.jpa.calendario;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cap.curso.jpa.calendario.servicios.CalendarioServiceInterface;
import cap.curso.jpa.configuracion.Configuracion;
import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuracion.class)
public class CalendarioTest
{

	@Autowired
	private CalendarioServiceInterface calendarioService;

	@Test
	public void calendarioSaveTest()
	{
		GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 8, 15);
		// Date fecha = new Date(Calendar.getInstance().getTime().getTime());
		Date fecha = new Date(gregorianCalendar.getTime().getTime());
		Calendario calendario = new Calendario();
		calendario.setFecha(fecha);
		Estado estado = new Estado();
		estado.setId(1);
		estado.setDescripcion("Laborable");
		calendario.setEstado(estado);

		calendarioService.save(calendario);
		// Assert.fail();
	}
	
	@Test
	public void calendarioUpdateTest() {
		Estado estado = new Estado();
		estado.setId(2);
		estado.setDescripcion("Festivo");
		
		calendarioService.updateCalendarioEstado(1, estado);
	}

}
