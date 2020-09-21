package cap.curso.jpa.repositorios;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cap.curso.jpa.entidades.Empleado;

@Repository
public interface EmpleadoJornadaRepositoryInterface extends CrudRepository<Empleado, Integer>
{


}
