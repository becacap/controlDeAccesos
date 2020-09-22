package cap.curso.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Calendario;
import cap.curso.jpa.entidades.Empleado;
import cap.curso.jpa.entidades.Usuario_Estado;
import cap.curso.jpa.repositorios.UsuariosEstadoRepositoryInterface;

@Service
public class UsuariosEstadoService implements UsuariosEstadoServiceInterface {

	@Autowired
	private UsuariosEstadoRepositoryInterface repositorio;
	
	public Usuario_Estado getDiasTrabajadosEmpleadoByYearByMes (Empleado empleado, Calendario cal) {
		Usuario_Estado ue = getRepositorio().getUsuarioEstadoByEmpleado (empleado, cal);
		
		return null;
	}

	public UsuariosEstadoRepositoryInterface getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(UsuariosEstadoRepositoryInterface repositorio) {
		this.repositorio = repositorio;
	}

}
