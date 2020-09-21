package cap.curso.jpa.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cap.curso.jpa.entidades.Usuario_Estado;

@Repository
public interface UsuariosEstadoRepositoryInterface extends CrudRepository<Usuario_Estado, Integer>
{

	@Query("from usuarios_estados r where r.empleados_id=:empleado_id")
	public Usuario_Estado getUsuarioEstadoByEmpleado(Integer empleado_id, Integer month, Integer year);
}
