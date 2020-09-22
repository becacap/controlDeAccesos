package cap.curso.jpa.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cap.curso.jpa.entidades.Usuario_Estado;

@Repository
public interface UsuariosEstadoRepositoryInterface extends CrudRepository<Usuario_Estado, Integer>
{

	@Query("from ((Usuario_Estado r natural join Estado e) natural join Jornada) where r.empleados_id=:empleado_id and e.descripcion='laborable'")
	public Usuario_Estado getUsuarioEstadoByEmpleado(Integer empleado_id, Integer month, Integer year);
}
