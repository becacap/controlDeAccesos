package cap.curso.jpa.servicios;

import java.util.Optional;

import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Empleado;

@Service
public interface JPAEmpleadoServiceInterface
{
	public Empleado save(Empleado empleado);
	
	public Iterable<Empleado> findAll();
	
	public Optional<Empleado> findById(Integer id);
}
