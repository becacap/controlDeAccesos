package cap.curso.jpa.calendario.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.jpa.calendario.exception.CalendarioAlreadyExistsException;
import cap.curso.jpa.calendario.exception.CalendarioNotFoundException;
import cap.curso.jpa.calendario.repositorios.CalendarioRepository;
import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;
import cap.curso.jpa.estado.exception.EstadoNotFoundException;
import cap.curso.jpa.estado.repositorios.EstadosRepository;

@Service
public class CalendarioService implements CalendarioServiceInterface
{

	@Autowired
	private CalendarioRepository calendarioRepository;

	@Autowired
	private EstadosRepository estadosRepository;

	public CalendarioRepository getCalendarioRepository()
	{
		return calendarioRepository;
	}

	public void setCalendarioRepository(CalendarioRepository calendarioRepository)
	{
		this.calendarioRepository = calendarioRepository;
	}

	public EstadosRepository getEstadosRepository()
	{
		return estadosRepository;
	}

	public void setEstadosRepository(EstadosRepository estadosRepository)
	{
		this.estadosRepository = estadosRepository;
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

	public Iterable<Calendario> generaCalendarioAnyo(Integer anyo)
			throws CalendarioAlreadyExistsException, EstadoNotFoundException
	{
		Iterable<Calendario> diasAnyo = getCalendarioRepository().findByAnyo(anyo.toString());

		Iterator<Calendario> it = diasAnyo.iterator();
		if (it.hasNext()) // si la lista de dias no esta vacia, no se genera calendario
		{
			throw new CalendarioAlreadyExistsException("El calendario ya existe en la bd");
		}
		Estado laborable = getEstadosRepository().findByDescripcion("Laborable");
		Estado festivo = getEstadosRepository().findByDescripcion("Festivo");
		if (laborable == null)
		{
			throw new EstadoNotFoundException("El estado Laborable no existe");
		} else if (festivo == null)
		{
			throw new EstadoNotFoundException("El estado Festivo no existe");
		}

		List<Calendario> listaDiasAnyo = new ArrayList<Calendario>();
		GregorianCalendar calendario = new GregorianCalendar(anyo, 0, 1); // instanciamos el año
		int daysInYear = calendario.getActualMaximum(Calendar.DAY_OF_YEAR);

		for (int i = 1; i <= daysInYear; ++i)
		{
			Calendario fila = new Calendario();
			Date fecha = new Date(calendario.getTime().getTime());
			fila.setFecha(fecha);

			int dayOfWeek = calendario.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek > 1 && dayOfWeek <= 6) // si es esntre semana
			{
				// System.out.println(calendario.getTime().toString() + " - DIARIO");
				fila.setEstado(laborable);

			} else // fin de semana
			{
				// System.out.println(calendario.getTime().toString() + " - FINDE");
				fila.setEstado(festivo);
			}

			Calendario insertado = getCalendarioRepository().save(fila);
			listaDiasAnyo.add(insertado);

			calendario.add(Calendar.DAY_OF_YEAR, 1); // avanzamos al dia siguiente
		}

		return listaDiasAnyo;
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
