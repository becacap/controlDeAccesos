package cap.curso.jpa.calendario.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cap.curso.jpa.entidades.Calendario;

@Repository
public interface CalendarioRepository extends CrudRepository<Calendario, Integer>
{
	@Query(value = "select * from calendarios c where extract(YEAR from c.fecha) = :anyo", nativeQuery = true)
	public Iterable<Calendario> findByAnyo(@Param("anyo") String anyo);
}
