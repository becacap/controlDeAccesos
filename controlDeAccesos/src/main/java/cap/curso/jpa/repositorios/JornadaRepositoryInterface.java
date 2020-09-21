package cap.curso.jpa.repositorios;

import org.springframework.stereotype.Repository;

import cap.curso.jpa.entidades.Jornada;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface JornadaRepositoryInterface extends CrudRepository<Jornada, Integer>
{

}
