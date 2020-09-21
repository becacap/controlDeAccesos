package cap.curso.jpa.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;

@Service
public interface CalendarioEmpleadoServiceInterface
{
	public void save(Calendario calendario, List<Estado> estados);
	
	public void update(int id_calendario,int id_empleado, int id_jornada, int id_estado);
}
