package cap.curso.controlDeAccesos;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cap.curso.jpa.configuracion.Configuracion;
import cap.curso.jpa.entidades.Jornada;
import cap.curso.jpa.servicios.JPAJornadaServiceInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuracion.class)
public class TestJornadas
{

	@Autowired
	JPAJornadaServiceInterface jpaJornadaServiceInterface;

	@Test
	public void testVerJornadas()
	{
		List<Jornada> jornadas = (List<Jornada>) getJpaJornadaServiceInterface().findAll();
		for (Jornada jornada : jornadas)
		{
			System.out.println(jornada.getId() + " - " + jornada.getDescripcion() + " - " + jornada.getLunes() + " - "
					+ jornada.getMartes() + " - " + jornada.getMiercoles() + " - " + jornada.getJueves() + " - "
					+ jornada.getViernes() + " - " + jornada.getEspecial());
		}
	}
	
	@Test
	public void testGuardarJornadas()
	{
		Jornada jornada = new Jornada();
		
		jornada.setDescripcion("Jornada Completa");
		jornada.setLunes("8:00-14:00&15:00-17:30");
		jornada.setMartes("8:00-14:00&15:00-17:30");
		jornada.setMiercoles("8:00-14:00&15:00-17:30");
		jornada.setJueves("8:00-14:00&15:00-17:30");
		jornada.setViernes("8:00-15:00");
		jornada.setEspecial(0);
		
		getJpaJornadaServiceInterface().save(jornada);
	}
	
	@Test
	public void testFindById()
	{
		Optional<Jornada> jornada = getJpaJornadaServiceInterface().findById(1);
		
		System.out.println(jornada.get().getDescripcion());
	}
	
	

	public JPAJornadaServiceInterface getJpaJornadaServiceInterface()
	{
		return jpaJornadaServiceInterface;
	}

	public void setJpaJornadaServiceInterface(JPAJornadaServiceInterface jpaJornadaServiceInterface)
	{
		this.jpaJornadaServiceInterface = jpaJornadaServiceInterface;
	}

}
