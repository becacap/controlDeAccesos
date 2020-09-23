package cap.curso.jpa.estado.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cap.curso.jpa.entidades.Estado;

@Repository
public interface EstadosRepository extends CrudRepository<Estado, Integer>
{

	@Query("from Estado e where e.descripcion = :descripcion")
	public Estado findByDescripcion(@Param("descripcion") String descripcion);

}
