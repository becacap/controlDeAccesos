package cap.curso.jpa.estado.exception;

@SuppressWarnings("serial")
public class EstadoNotFoundException extends Exception
{
	public EstadoNotFoundException(String msg)
	{
		super(msg);
	}
}
