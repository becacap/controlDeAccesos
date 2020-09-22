package cap.curso.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.jpa.calendario_empleado.repositorios.CalendarioEmpleadoRepositoryInterface;
import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;
import cap.curso.jpa.entidades.Usuario_Estado;

@Service
public class CalendarioEmpleadoService implements CalendarioEmpleadoServiceInterface
{
	@Autowired
	private CalendarioEmpleadoRepositoryInterface calendarioEmpleadoRepository;
	
	public Usuario_Estado save(Usuario_Estado usuario_Estado)
	{
		return getCalendarioEmpleadoRepository().save(usuario_Estado);

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
