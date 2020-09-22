package cap.curso.jpa.servicios;

import java.util.Optional;

import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Jornada;

@Service
public interface JPAJornadaServiceInterface
{
	
	public Jornada save(Jornada jornada);
	
	public Iterable<Jornada> findAll();
	
	public Optional<Jornada> findById(Integer id);
}
