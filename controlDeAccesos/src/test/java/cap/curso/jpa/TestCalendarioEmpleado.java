package cap.curso.jpa;

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
import cap.curso.jpa.entidades.Empleado;
import cap.curso.jpa.entidades.Estado;
import cap.curso.jpa.entidades.Jornada;
import cap.curso.jpa.entidades.Usuario_Estado;
import cap.curso.jpa.servicios.CalendarioEmpleadoServiceInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuracion.class)
public class TestCalendarioEmpleado
{
	@Autowired
	private CalendarioEmpleadoServiceInterface calendarioEmpleado;

	@Test
	public void testSave()
	{
		Usuario_Estado usuario_Estado = new Usuario_Estado();
		
		Empleado empleado = new Empleado();
		empleado.setNombre("Juanito");
		empleado.setApellidos("G");
		empleado.setDni("34249867D");
		empleado.setIdentificador("11111111");
		empleado.setFecha_alta(new Date(998888));
		
		Calendario calendario = new Calendario();
		GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 9, 21);
		Date fecha = new Date(gregorianCalendar.getTime().getTime());
		calendario.setFecha(fecha);
		
		Estado estado = new Estado(); 
		estado.setId(1);
		estado.setDescripcion("Festivo");
		
		Jornada jornada = new Jornada();
		jornada.setDescripcion("Jornada Completa");
		jornada.setLunes("8:00-14:00&15:00-17:30");
		jornada.setMartes("8:00-14:00&15:00-17:30");
		jornada.setMiercoles("8:00-14:00&15:00-17:30");
		jornada.setJueves("8:00-14:00&15:00-17:30");
		jornada.setViernes("8:00-15:00");
		jornada.setEspecial(0);
		
		usuario_Estado.setEmpleado(empleado);
		usuario_Estado.setCalendario(calendario);
		usuario_Estado.setEstado(estado);
		usuario_Estado.setJornada(jornada);
		usuario_Estado = getCalendarioEmpleado().save(usuario_Estado);
		// enero1 = getCalendario()byYear();
		// getEmpleadobyId();

		/*
		 * Usuario_Estado usuario_Estado = new Usuario_Estado();
		 * usuario_Estado.setEmpleado(empleado);
		 * 
		 * for (Calendario calendario : getCalendarioByYear()) {
		 * usuario_Estado.setCalendario(calendario);
		 * 
		 * calendarioEmpleado.save(usuario_Estado); }
		 */

		/*
		 * GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 9, 21);
		 * Date fecha = new Date(gregorianCalendar.getTime().getTime()); Calendario
		 * calendario = new Calendario(); calendario.setId(1);
		 * calendario.setFecha(fecha); Estado e1 = new Estado(); Estado e2 = new
		 * Estado(); Estado e3 = new Estado(); e1.setId(1);
		 * e1.setDescripcion("Festivo"); e2.setId(2); e2.setDescripcion("Laboral");
		 * e3.setId(3); e3.setDescripcion("Festivo"); List<Estado> estados = new
		 * ArrayList<Estado>(); estados.add(e1); estados.add(e2); estados.add(e3);
		 * getCalendarioEmpleado().save(calendario, estados);
		 */
	}

	public CalendarioEmpleadoServiceInterface getCalendarioEmpleado()
	{
		return calendarioEmpleado;
	}

	public void setCalendarioEmpleado(CalendarioEmpleadoServiceInterface calendarioEmpleado)
	{
		this.calendarioEmpleado = calendarioEmpleado;
	}

	@Test
	public void testUpdateEstado()
	{
		Usuario_Estado usuario_estado = new Usuario_Estado();
		Empleado empleado = new Empleado();
		empleado.setNombre("Juanito");
		empleado.setApellidos("G");
		empleado.setDni("34249867D");
		empleado.setIdentificador("11111111");
		empleado.setFecha_alta(new Date(998888));
		
		Calendario calendario = new Calendario();
		GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 9, 21);
		Date fecha = new Date(gregorianCalendar.getTime().getTime());
		calendario.setFecha(fecha);
		
		Estado estado = new Estado(); 
		estado.setId(1);
		estado.setDescripcion("Festivo");
		
		Jornada jornada = new Jornada();
		jornada.setDescripcion("Jornada Completa");
		jornada.setLunes("8:00-14:00&15:00-17:30");
		jornada.setMartes("8:00-14:00&15:00-17:30");
		jornada.setMiercoles("8:00-14:00&15:00-17:30");
		jornada.setJueves("8:00-14:00&15:00-17:30");
		jornada.setViernes("8:00-15:00");
		jornada.setEspecial(0);
		
		usuario_estado.setEmpleado(empleado);
		usuario_estado.setCalendario(calendario);
		usuario_estado.setEstado(estado);
		usuario_estado.setJornada(jornada);
		
		getCalendarioEmpleado().update(usuario_estado.getCalendario().getId(), 
				usuario_estado.getEmpleado().getId(),
				usuario_estado.getJornada().getId(), 
				usuario_estado.getEstado().getId());
		
		/*
		 * Calendario calendario = getCalendarioById(); Empleado empleado =
		 * getEmpleadoById(); Jornada jornada = getJornadaById();
		 * 
		 * if (calendario.getEstado().getId() == 1) calendario.getEstado().setId(2);
		 * else { calendario.getEstado().setId(1); }
		 * 
		 * getCalendarioEmpleado().update(calendario.getId(), empleado.getId(),
		 * jornada.getId(), calendario.getEstado().getId());
		 */
	}

	@Test
	public void testUpdateJornada()
	{

		/*
		 * Calendario calendario = getCalendarioById(); Empleado empleado =
		 * getEmpleadoById(); Jornada jornada = getJornadaById();
		 * 
		 * // Updatear a mano a otra jornada Id
		 * 
		 * 
		 * getCalendarioEmpleado().update(calendario.getId(), empleado.getId(),
		 * jornada.getId(), calendario.getEstado().getId());
		 * 
		 */
	}

	/*
	 * @Test public void testUpdate() {
	 * 
	 * GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 9, 21);
	 * Date fecha = new Date(gregorianCalendar.getTime().getTime());
	 * 
	 * Calendario calendario = new Calendario(); calendario.setId(1);
	 * calendario.setFecha(fecha);
	 * 
	 * Empleado empleado = new Empleado(); empleado.setId(1);
	 * 
	 * Jornada jornada = new Jornada(); jornada.setId(1);
	 * 
	 * Estado estado = new Estado(); estado.setId(1);
	 * 
	 * getCalendarioEmpleado().update(calendario.getId(), empleado.getId(),
	 * jornada.getId(), estado.getId());
	 * 
	 * }
	 */

}
