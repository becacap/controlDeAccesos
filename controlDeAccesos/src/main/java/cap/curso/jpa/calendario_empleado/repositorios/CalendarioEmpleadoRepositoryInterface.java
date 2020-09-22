package cap.curso.jpa.calendario_empleado.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import cap.curso.jpa.entidades.Acceso;
import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;
import cap.curso.jpa.entidades.Usuario_Estado;

@Repository
public interface CalendarioEmpleadoRepositoryInterface extends CrudRepository<Usuario_Estado, Integer>
{

	//@Query("update Calendario c set c.estado=:estado where c.id = id_calendario")
	public void update(Integer id_calendario, Integer id_empleado, Integer id_jornada, Integer id_estado);



}
