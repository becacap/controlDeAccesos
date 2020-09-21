package cap.curso.jpa.calendario_empleado.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cap.curso.jpa.entidades.Acceso;

@Repository
public interface Calendario_empleadoRepositoryInterface extends CrudRepository<Acceso, Integer>
{
	
	
}
