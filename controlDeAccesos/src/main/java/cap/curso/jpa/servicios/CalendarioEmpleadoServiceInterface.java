package cap.curso.jpa.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;

@Service
public interface CalendarioEmpleadoServiceInterface
{
	public Calendario save(Calendario calendario, List<Estado> estados);
	
	public void update(Integer id_calendario,Integer id_empleado, Integer id_jornada, Integer id_estado);
}
