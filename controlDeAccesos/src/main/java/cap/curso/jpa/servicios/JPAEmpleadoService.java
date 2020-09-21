package cap.curso.jpa.servicios;

import java.util.Optional;

import cap.curso.jpa.entidades.Empleado;
import cap.curso.jpa.repositorios.EmpleadoRepositoryInterface;

public class JPAEmpleadoService implements JPAEmpleadoServiceInterface
{

	private EmpleadoRepositoryInterface empleadoRepo;
	
	public Empleado save(Empleado empleado)
	{
		return getEmpleadoRepo().save(empleado);
	}

	public Iterable<Empleado> findAll()
	{
		// TODO Auto-generated method stub
		return getEmpleadoRepo().findAll();
	}

	public Optional<Empleado> findById(Integer id) {
		return getEmpleadoRepo().findById(id);
	}
	
//	############ GETTER && SETTER  ###########################
	public EmpleadoRepositoryInterface getEmpleadoRepo()
	{
		return empleadoRepo;
	}

	public void setEmpleadoRepo(EmpleadoRepositoryInterface empleadoRepo)
	{
		this.empleadoRepo = empleadoRepo;
	}

}
