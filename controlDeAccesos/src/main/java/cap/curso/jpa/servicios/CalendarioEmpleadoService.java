package cap.curso.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.jpa.calendario_empleado.repositorios.CalendarioEmpleadoRepositoryInterface;
import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;

@Service
public class CalendarioEmpleadoService implements CalendarioEmpleadoServiceInterface
{
	@Autowired
	private CalendarioEmpleadoRepositoryInterface calendarioEmpleadoRepository;
	
	public Calendario save(Calendario calendario, List<Estado> estados)
	{
		return getCalendarioEmpleadoRepository().save(calendario, estados);

	}

	public void update(Integer id_calendario, Integer id_empleado, Integer id_jornada, Integer id_estado)
	{
		getCalendarioEmpleadoRepository().update(id_calendario, id_empleado, id_jornada, id_estado);

	}

	public CalendarioEmpleadoRepositoryInterface getCalendarioEmpleadoRepository()
	{
		return calendarioEmpleadoRepository;
	}

	public void setCalendarioEmpleadoRepository(CalendarioEmpleadoRepositoryInterface calendarioEmpleadoRepository)
	{
		this.calendarioEmpleadoRepository = calendarioEmpleadoRepository;
	}

	
	

}
