package cap.curso.jpa.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Estado;
import cap.curso.jpa.entidades.Usuario_Estado;

@Service
public interface CalendarioEmpleadoServiceInterface
{
	public Usuario_Estado save(Usuario_Estado usuario_Estado);
	
	public void update(Integer id_calendario,Integer id_empleado, Integer id_jornada, Integer id_estado);
}
