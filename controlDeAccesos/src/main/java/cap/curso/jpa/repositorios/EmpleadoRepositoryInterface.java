package cap.curso.jpa.repositorios;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cap.curso.jpa.entidades.Empleado;

@Repository
public interface EmpleadoRepositoryInterface extends CrudRepository<Empleado, Integer>
{
	
}
