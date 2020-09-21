package cap.curso.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Usuario_Estado;
import cap.curso.jpa.repositorios.UsuariosEstadoRepositoryInterface;

@Service
public class UsuariosEstadoService implements UsuariosEstadoInterface {

	@Autowired
	private UsuariosEstadoRepositoryInterface repositorio;
	
	public Usuario_Estado getDiasTrabajadosEmpleadoByYearByMes(Integer idEmpleado, Integer year, Integer mes) {
		return getRepositorio().getUsuarioEstadoByEmpleado(idEmpleado, year, mes);
		
	}

	public UsuariosEstadoRepositoryInterface getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(UsuariosEstadoRepositoryInterface repositorio) {
		this.repositorio = repositorio;
	}

}
