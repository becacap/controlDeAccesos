package cap.curso.jpa.services;

import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Empleado;
import cap.curso.jpa.entidades.Usuario_Estado;

@Service
public interface UsuariosEstadoServiceInterface {
	
	public Usuario_Estado getDiasTrabajadosEmpleadoByYearByMes (Empleado empleado, Calendario cal);
	
}
