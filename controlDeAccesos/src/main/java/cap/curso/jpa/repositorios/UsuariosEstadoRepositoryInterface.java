package cap.curso.jpa.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Empleado;
import cap.curso.jpa.entidades.Usuario_Estado;

@Repository
public interface UsuariosEstadoRepositoryInterface extends CrudRepository<Usuario_Estado, Integer>
{
	
	//from Usuario_Estado ue where ue.emplead=:empleado and ue.calendario=:calendario

	@Query("from Usuario_Estado ue where ue.empleado=:empleado and ue.calendario=:calendario")
	public Usuario_Estado getUsuarioEstadoByEmpleado(Empleado empleado,Calendario calendario);
}
