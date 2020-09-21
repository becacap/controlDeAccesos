package cap.curso.jpa.calendario_empleado;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cap.curso.jpa.configuracion.Configuracion;
import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;
import cap.curso.jpa.servicios.CalendarioEmpleadoServiceInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuracion.class)
public class TestUpdate
{
	@Autowired
	private CalendarioEmpleadoServiceInterface calendarioEmpleado;
	@Test
	public void testSave()
	{
		Date fecha = new Date(01, 01, 2020);
		Calendario calendario = new Calendario();
		calendario.setId(1);
		calendario.setFecha(fecha);
		Estado e1 = new Estado();
		Estado e2 = new Estado();
		Estado e3 = new Estado();
		e1.setId(1);
		e1.setDescripcion("Festivo");
		e2.setId(2);
		e2.setDescripcion("Laboral");
		e3.setId(3);
		e3.setDescripcion("Festivo");
		List<Estado> estados = new ArrayList<Estado>();
		estados.add(e1);
		estados.add(e2);
		estados.add(e3);
		getCalendarioEmpleado().save(calendario, estados);
	}
	
	
	public CalendarioEmpleadoServiceInterface getCalendarioEmpleado()
	{
		return calendarioEmpleado;
	}
	public void setCalendarioEmpleado(CalendarioEmpleadoServiceInterface calendarioEmpleado)
	{
		this.calendarioEmpleado = calendarioEmpleado;
	}

}
