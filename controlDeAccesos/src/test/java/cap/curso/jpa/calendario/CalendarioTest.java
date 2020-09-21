package cap.curso.jpa.calendario;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cap.curso.jpa.calendario.exception.CalendarioAlreadyExistsException;
import cap.curso.jpa.calendario.exception.CalendarioNotFoundException;
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

	public CalendarioServiceInterface getCalendarioService()
	{
		return calendarioService;
	}

	public void setCalendarioService(CalendarioServiceInterface calendarioService)
	{
		this.calendarioService = calendarioService;
	}

	// @Test
	public void calendarioSaveOkTest() throws CalendarioAlreadyExistsException
	{
		GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 8, 15);
		Date fecha = new Date(gregorianCalendar.getTime().getTime());

		// insert into estados values (1, "Laborable");
		// insert into estados values (2, "Festivo");

		Estado estado = new Estado();
		estado.setDescripcion("Festivo");
		estado.setId(2);

		Calendario calendario = new Calendario();
		calendario.setFecha(fecha);
		calendario.setEstado(estado);

		Calendario result = calendarioService.save(calendario);

		Assert.assertNotEquals(result.getId(), null);
	}

	// @Test(expected = CalendarioAlreadyExistsException.class)
	public void calendarioSaveNoOkTest() throws CalendarioAlreadyExistsException
	{
		GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 8, 15);
		Date fecha = new Date(gregorianCalendar.getTime().getTime());

		Estado estado = new Estado();
		estado.setDescripcion("Laborable");
		estado.setId(1);

		// Este calendario ya debe de existir en la bd para que lance la excepcion el
		// servicio
		Calendario calendario = new Calendario();
		calendario.setId(2);
		calendario.setFecha(fecha);
		calendario.setEstado(estado);

		Calendario result = calendarioService.save(calendario);

		Assert.assertEquals(result, null);
	}

	// @Test
	public void calendarioUpdateOkTest() throws CalendarioNotFoundException
	{

		Estado estado = new Estado();
		estado.setDescripcion("Laborable");
		estado.setId(1);

		Calendario result = calendarioService.updateCalendarioEstado(8, estado);

	}

	// @Test(expected = CalendarioNotFoundException.class)
	public void calendarioUpdateNoOkTest() throws CalendarioNotFoundException
	{

		Estado estado = new Estado();
		estado.setDescripcion("Laborable");
		estado.setId(1);

		Calendario result = calendarioService.updateCalendarioEstado(232, estado);

	}

	@Test
	public void calendarioGenerarOkTest() throws CalendarioAlreadyExistsException
	{
		Integer anyo = 2021;

		Iterable<Calendario> lista = getCalendarioService().generaCalendarioAnyo(anyo);

		for (Calendario c : lista)
		{
			System.out.println(c.getId());
		}
	}

}
