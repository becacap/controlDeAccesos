package cap.curso.jpa.calendario_empleado.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import cap.curso.jpa.entidades.Acceso;
import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;

@Repository
public interface CalendarioEmpleadoRepositoryInterface extends CrudRepository<Calendario, Integer>
{
	
	//@Query("")
	Calendario save(Calendario calendario, List<Estado> estados);

	//@Query("update Calendario c set c.estado=:estado where exists (select e from Empleado e where e.)")
	void update(Integer id_calendario, Integer id_empleado, Integer id_jornada, Integer id_estado);



}
