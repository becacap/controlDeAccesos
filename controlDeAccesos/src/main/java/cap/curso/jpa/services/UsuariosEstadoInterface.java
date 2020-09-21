package cap.curso.jpa.services;

import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Usuario_Estado;

@Service
public interface UsuariosEstadoInterface {
	
	public Usuario_Estado getDiasTrabajadosEmpleadoByYearByMes (Integer idEmpleado, Integer year, Integer mes);
	
}
