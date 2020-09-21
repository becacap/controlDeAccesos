package cap.curso.jpa.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import cap.curso.jpa.entidades.Usuario_Estado;


public interface UsuariosEstadoRepositoryInterface extends CrudRepository<Usuario_Estado, Integer>
{

	@Query("from usuarios_estados r where r.empleados_id=:empleado_id")
	public Usuario_Estado diasTrabajados(Integer empleado_id, Integer month, Integer year);
}
