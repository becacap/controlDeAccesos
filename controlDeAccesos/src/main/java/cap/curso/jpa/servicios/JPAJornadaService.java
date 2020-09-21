package cap.curso.jpa.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.jpa.entidades.Jornada;

@Service
public class JPAJornadaService implements JPAJornadaServiceInterface
{
	@Autowired
	JPAJornadaServiceInterface jornadaServiceInterface;

	public Jornada save(Jornada jornada)
	{
		return getJornadaServiceInterface().save(jornada);
	}

	public Iterable<Jornada> findAll()
	{
		return getJornadaServiceInterface().findAll();
	}

	public Iterable<Jornada> findById()
	{
		return getJornadaServiceInterface().findById();
	}

	public JPAJornadaServiceInterface getJornadaServiceInterface()
	{
		return jornadaServiceInterface;
	}

	public void setJornadaServiceInterface(JPAJornadaServiceInterface jornadaServiceInterface)
	{
		this.jornadaServiceInterface = jornadaServiceInterface;
	}
	
	

}
