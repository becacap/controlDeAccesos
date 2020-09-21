package cap.curso.jpa.calendario.servicios;

import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;

@Service
public interface CalendarioServiceInterface
{

	public Calendario save(Calendario calendario);

	public void generaCalendarioAnyo(Integer anyo);

	public Calendario updateCalendarioEstado(Integer idCalendario, Estado estado);

}
