package tt.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "jugador", catalog = "gestor_equipo")
public class Jugador implements java.io.Serializable {

	private Integer idJug;
	private Equipo equipo;
	private String nombre;
	private String puesto;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaNacimiento;
	private String lugarNacimiento;
	private String email;

	public Jugador() {
	}

	public Jugador(Equipo equipo) {
		this.equipo = equipo;
	}

	public Jugador(Equipo equipo, String nombre, String puesto, Date fechaNacimiento, String lugarNacimiento,
			String email) {
		this.equipo = equipo;
		this.nombre = nombre;
		this.puesto = puesto;
		this.fechaNacimiento = fechaNacimiento;
		this.lugarNacimiento = lugarNacimiento;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

//	@Column(name = "idJug", unique = true, nullable = false)
	public Integer getIdJug() {
		return this.idJug;
	}

	public void setIdJug(Integer idJug) {
		this.idJug = idJug;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEq", nullable = false)
	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

//	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	@Column(name = "puesto", length = 45)
	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "fechaNacimiento", length = 26)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

//	@Column(name = "lugarNacimiento", length = 45)
	public String getLugarNacimiento() {
		return this.lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

//	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Jugador [idJug=" + idJug + ", equipo=" + equipo + ", nombre=" + nombre + ", puesto=" + puesto
				+ ", fechaNacimiento=" + fechaNacimiento + ", lugarNacimiento=" + lugarNacimiento + ", email=" + email
				+ "]";
	}

}
