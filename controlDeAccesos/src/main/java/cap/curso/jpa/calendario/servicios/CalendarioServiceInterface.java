package cap.curso.jpa.calendario.servicios;

import org.springframework.stereotype.Service;

import cap.curso.jpa.calendario.exception.CalendarioAlreadyExistsException;
import cap.curso.jpa.calendario.exception.CalendarioNotFoundException;
import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;

@Service
public interface CalendarioServiceInterface
{

	public Iterable<Calendario> findAll();

	public Calendario save(Calendario calendario) throws CalendarioAlreadyExistsException;

	public Iterable<Calendario> generaCalendarioAnyo(Integer anyo) throws CalendarioAlreadyExistsException;

	public Calendario updateCalendarioEstado(Integer idCalendario, Estado estado) throws CalendarioNotFoundException;

}
