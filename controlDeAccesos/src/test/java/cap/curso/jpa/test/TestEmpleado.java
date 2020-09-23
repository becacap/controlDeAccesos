package cap.curso.jpa.test;

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
	
	@Test
	public void testEmpleadoByID() {
		Optional<Empleado> e = Optional.ofNullable(new Empleado());
		e = getJpaEmpleadoSI().findById(1);
		System.out.println(e.get().getNombre() + "@@@@@@@@@@@@@@@@@@@@@@@@@@");
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
