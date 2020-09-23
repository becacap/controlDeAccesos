package cap.curso.jpa.estado.servicios;

import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Estado;

@Service
public interface EstadosServiceInterface
{

	public Estado findByDescripcion(String descripcion);
	
}
