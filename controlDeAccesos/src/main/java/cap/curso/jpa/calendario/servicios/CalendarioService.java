package cap.curso.jpa.calendario.servicios;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.jpa.calendario.exception.CalendarioAlreadyExistsException;
import cap.curso.jpa.calendario.exception.CalendarioNotFoundException;
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

	public Iterable<Calendario> findAll()
	{
		return getCalendarioRepository().findAll();
	}

	public Calendario save(Calendario calendario) throws CalendarioAlreadyExistsException
	{
		Calendario calendarioSearched = getCalendarioRepository().findById(calendario.getId()).orElse(null);

		if (calendarioSearched == null)
		{
			return getCalendarioRepository().save(calendario);
		} else
		{
			throw new CalendarioAlreadyExistsException("El calendario ya existe en la bd existe");
		}
	}

	public Iterable<Calendario> generaCalendarioAnyo(Integer anyo) throws CalendarioAlreadyExistsException
	{
		Iterable<Calendario> diasAnyo = getCalendarioRepository().findByAnyo(anyo.toString());

		Iterator<Calendario> it = diasAnyo.iterator();
		if (it.hasNext()) // si la lista de dias no esta vacia, no se genera calendario
		{
			throw new CalendarioAlreadyExistsException("El calendario ya existe en la bd");
		}

		GregorianCalendar calendario = new GregorianCalendar(anyo, 0, 1); // instanciamos el año

		int month = calendario.get(GregorianCalendar.MONTH);
		while (month <= 11)
		{
			int nextMonth = calendario.get(GregorianCalendar.MONTH) + 1;
			month = nextMonth > month ? nextMonth : -1;

			int dayOfMonth = 1;
			int monthDaysCount = calendario.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			while (dayOfMonth <= monthDaysCount)
			{
				int nextDay = calendario.get(GregorianCalendar.DAY_OF_MONTH) + 1;
				dayOfMonth = nextDay > dayOfMonth ? nextDay : -1;

				// System.out.println(calendario.getTime().toString());

				calendario.set(GregorianCalendar.DAY_OF_MONTH, dayOfMonth);
			}

			calendario.set(GregorianCalendar.MONTH, month);
		}

		return diasAnyo;
	}

	public Calendario updateCalendarioEstado(Integer idCalendario, Estado estado) throws CalendarioNotFoundException
	{
		// el metodo get() devuelve la excepcion NoSuchElementException y nosotros
		// queremos devolver null
		// Calendario calendarioSearched =
		// getCalendarioRepository().findById(idCalendario).get();
		Calendario calendarioSearched = getCalendarioRepository().findById(idCalendario).orElse(null);

		if (calendarioSearched != null)
		{
			calendarioSearched.setEstado(estado);
			return getCalendarioRepository().save(calendarioSearched);
		} else
		{
			throw new CalendarioNotFoundException("El calendario no existe");
		}
	}

}
