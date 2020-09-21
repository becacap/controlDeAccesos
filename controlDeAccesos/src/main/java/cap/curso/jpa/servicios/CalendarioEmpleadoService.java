package cap.curso.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;

@Service
public class CalendarioEmpleadoService implements CalendarioEmpleadoServiceInterface
{
	@Autowired
	//Cambiar Service por Repository
	private CalendarioEmpleadoServiceInterface calendarioEmpleadoServiceInterface;
	public void save(Calendario calendario, List<Estado> estados)
	{
		getCalendarioEmpleadoServiceInterface().save(calendario, estados);

	}

	public void update(Integer id_calendario, Integer id_empleado, Integer id_jornada, Integer id_estado)
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
