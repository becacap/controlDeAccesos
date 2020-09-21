package cap.curso.jpa.calendario.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.jpa.calendario.repositorios.CalendarioRepository;
import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;

@Service
public class CalendarioService implements CalendarioServiceInterface
{

	@Autowired
	private CalendarioRepository calendarioRepository;

	public CalendarioRepository getCalendarioRepository()
	{
		return calendarioRepository;
	}

	public void setCalendarioRepository(CalendarioRepository calendarioRepository)
	{
		this.calendarioRepository = calendarioRepository;
	}

	public Calendario save(Calendario calendario)
	{
		return getCalendarioRepository().save(calendario);
	}

	public void generaCalendarioAnyo(Integer anyo)
	{
		// TODO Auto-generated method stub

	}

	public Calendario updateCalendarioEstado(Integer idCalendario, Estado estado)
	{
		// Calendario calendario = getCalendarioRepository().findById(idCalendario);
		// return getCalendarioRepository().save(calendario);
		return null;
	}

}
