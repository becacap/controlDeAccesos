package cap.curso.jpa.calendario.exception;

@SuppressWarnings("serial")
public class CalendarioNotFoundException extends Exception
{

	public CalendarioNotFoundException(String msg)
	{
		super(msg);
	}

}