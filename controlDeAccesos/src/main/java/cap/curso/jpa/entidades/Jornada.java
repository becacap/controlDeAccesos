package cap.curso.jpa.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jornadas")
public class Jornada
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String lunes;

	@Column
	private String martes;

	@Column
	private String miercoles;

	public String getViernes()
	{
		return viernes;
	}

	public void setViernes(String viernes)
	{
		this.viernes = viernes;
	}

	@Column
	private String jueves;
	
	@Column
	private String viernes;

	@Column
	private String descripcion;

	@Column
	private int especial;

	@ManyToMany
	@JoinTable(name = "empleado_jornadas", joinColumns = @JoinColumn(name = "jornadas_id"), inverseJoinColumns = @JoinColumn(name = "empleados_id"))
	private List<Empleado> empleados;

	public List<Empleado> getEmpleados()
	{
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados)
	{
		this.empleados = empleados;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getLunes()
	{
		return lunes;
	}

	public void setLunes(String lunes)
	{
		this.lunes = lunes;
	}

	public String getMartes()
	{
		return martes;
	}

	public void setMartes(String martes)
	{
		this.martes = martes;
	}

	public String getMiercoles()
	{
		return miercoles;
	}

	public void setMiercoles(String miercoles)
	{
		this.miercoles = miercoles;
	}

	public String getJueves()
	{
		return jueves;
	}

	public void setJueves(String jueves)
	{
		this.jueves = jueves;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public int getEspecial()
	{
		return especial;
	}

	public void setEspecial(int especial)
	{
		this.especial = especial;
	}

}
