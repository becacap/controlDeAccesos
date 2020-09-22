package cap.curso.jpa;

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
import cap.curso.jpa.entidades.Rol;
import cap.curso.jpa.entidades.Usuario;
import cap.curso.jpa.servicios.JPAEmpleadoServiceInterface;
import cap.curso.jpa.servicios.JPARolesServiceInterface;
import cap.curso.jpa.servicios.JPAUsuarioServiceInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuracion.class)

public class TestUsuario
{
	@Autowired
	private JPAUsuarioServiceInterface jPAUsuarioServiceInterface;
	@Autowired
	private JPARolesServiceInterface jpaRolesServiceInterface;
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
//	 @Test
	public void testTodosUsuario()
	{
		List<Usuario> usuarios = (List<Usuario>) getJpaUsuarioServiceInterface().findAll();
		for (Usuario usuario : usuarios)
		{
			System.out.println(usuario.getUsuario() + " - " + usuario.getClave());
		}
	}
//	 @Test
	public void testTodosRoles()
	{
		List<Rol> roles = (List<Rol>) getJpaRolesServiceInterface().findAll();
		for (Rol rol : roles)
		{
			System.out.println(rol.getRol());
		}
	}
//	 @Test
	 public void altaUsuario() {
		 Rol rol = getJpaRolesServiceInterface().getRolByRol("ADMINISTRADOR");
		 System.out.println(rol.getRol());
		 Usuario u = new Usuario();
		 u.setUsuario("User");
		 u.setClave("1234");
		 u.setEnabled(1);
		 u.setRol(rol);
		 getJpaUsuarioServiceInterface().save(u);
	 }

//	@Test
	public void grabar()
	{
		Rol rol = new Rol();
		rol.setRol("USUARIO");
		getJpaRolesServiceInterface().save(rol);
		Rol rol2 = new Rol();
		rol2.setRol("ADMINISTRADOR");
		getJpaRolesServiceInterface().save(rol2);
	}

	
	// ###############################  GETTER && SETTER  ##########################################
	public JPAUsuarioServiceInterface getJpaUsuarioServiceInterface()
	{
		return jPAUsuarioServiceInterface;
	}

	public void setJpaUsuarioServiceInterface(JPAUsuarioServiceInterface jPAServiceInterface)
	{
		this.jPAUsuarioServiceInterface = jPAServiceInterface;
	}

	public JPARolesServiceInterface getJpaRolesServiceInterface()
	{
		return jpaRolesServiceInterface;
	}

	public void setJpaRolesServiceInterface(JPARolesServiceInterface jpaRolesServiceInterface)
	{
		this.jpaRolesServiceInterface = jpaRolesServiceInterface;
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
