package cap.curso.jpa.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;

@Service
public class CalendarioEmpleadoService implements CalendarioEmpleadoServiceInterface
{
	//Cambiar Service por Repository
	private CalendarioEmpleadoServiceInterface calendarioEmpleadoServiceInterface;
	public void save(Calendario calendario, List<Estado> estados)
	{
		getCalendarioEmpleadoServiceInterface().save(calendario, estados);

	}

	public void update(int id_calendario, int id_empleado, int id_jornada, int id_estado)
	{
		getCalendarioEmpleadoServiceInterface().update(id_calendario, id_empleado, id_jornada, id_estado);

	}

	public CalendarioEmpleadoServiceInterface getCalendarioEmpleadoServiceInterface()
	{
		return calendarioEmpleadoServiceInterface;
	}

	public void setCalendarioEmpleadoServiceInterface(CalendarioEmpleadoServiceInterface calendarioEmpleadoServiceInterface)
	{
		this.calendarioEmpleadoServiceInterface = calendarioEmpleadoServiceInterface;
	}

}
