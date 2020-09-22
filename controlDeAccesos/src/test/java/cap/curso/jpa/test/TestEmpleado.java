package cap.curso.jpa.test;

import static org.junit.Assert.assertNotEquals;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cap.curso.jpa.configuracion.Configuracion;
import cap.curso.jpa.entidades.Empleado;
import cap.curso.jpa.entidades.Jornada;
import cap.curso.jpa.servicios.JPAEmpleadoService;
import cap.curso.jpa.servicios.JPAEmpleadoServiceInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuracion.class)

public class TestEmpleado
{

	@Autowired
	private JPAEmpleadoServiceInterface jpaEmpleadoSI;

	
	
//	@Test
	public void crearEmpleado(){
		Empleado e = new Empleado();
		e.setNombre("Juanito");
		e.setApellidos("G");
		e.setDni("34249867D");
		e.setIdentificador("11111111");
		e.setFecha_alta(new Date(998888));
		getJpaEmpleadoSI().save(e);
	}
	
//	@Test
	public void testTodosEmpleados()
	{
		List<Empleado> e = (List<Empleado>) getJpaEmpleadoSI().findAll();
		for (Empleado emp : e)
		{
			System.out.println(emp.getNombre());
		}
	}
	
//	@Test
	public void testEmpleadoByID() {
		Optional<Empleado> e = Optional.ofNullable(new Empleado());
		e = getJpaEmpleadoSI().findById(1);
		System.out.println(e.get().getNombre() + "@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	@Test
	public void testModificarJornada() {
		Jornada jornada2 = new Jornada();
		jornada2.setLunes("9h-16h");
		jornada2.setMartes("9h-16h");
		jornada2.setMiercoles("9h-16h");
		jornada2.setJueves("9h-16h");
		jornada2.setViernes("9h-16h");
		jornada2.setDescripcion("Maña-Tarde");
		Empleado empleado = new Empleado();
		empleado.setNombre("Juanito");
		empleado.setApellidos("G");
		empleado.setDni("34249867D");
		empleado.setIdentificador("11111111");
		empleado.setFecha_alta(new Date(998888));
		empleado.setJornada(jornada2);
		Empleado empleadoSinCambios = empleado;
		Jornada jornada = new Jornada();
		jornada.setLunes("9h-15h");
		jornada.setMartes("9h-15h");
		jornada.setMiercoles("9h-15h");
		jornada.setJueves("9h-15h");
		jornada.setViernes("9h-15h");
		jornada.setDescripcion("Mañana");
		jornada.setEspecial(0);
		jpaEmpleadoSI.modificarJornada(empleado,jornada);
		System.out.println(empleado.getJornada().getId());
		System.out.println(empleadoSinCambios.getJornada().getId());
		assertNotEquals(empleado.getJornada().getId(), empleadoSinCambios.getJornada().getId());
	}

	public JPAEmpleadoServiceInterface getJpaEmpleadoSI()
	{
		return jpaEmpleadoSI;
	}
	public void setJpaEmpleadoSI(JPAEmpleadoServiceInterface jpaEmpleadoSI)
	{
		this.jpaEmpleadoSI = jpaEmpleadoSI;
	}

}
