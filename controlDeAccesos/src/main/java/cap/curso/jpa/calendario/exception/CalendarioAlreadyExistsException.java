package cap.curso.jpa.calendario.exception;

@SuppressWarnings("serial")
public class CalendarioAlreadyExistsException extends Exception
{

	public CalendarioAlreadyExistsException(String msg)
	{
		super(msg);
	}

}
