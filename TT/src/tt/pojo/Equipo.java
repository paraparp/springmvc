package tt.pojo;
// Generated 24-ene-2019 17:21:23 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "equipo",
        catalog = "gestor_equipo"
)
public class Equipo implements java.io.Serializable
{

    private Integer idEq;
    private String nombre;
    private String division;
    private Set<Jugador> jugadors = new HashSet<Jugador>(0);

    public Equipo()
    {
    }

    public Equipo(String nombre,String division,Set<Jugador> jugadors)
    {
        this.nombre = nombre;
        this.division = division;
        this.jugadors = jugadors;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idEq",unique = true,nullable = false)
    public Integer getIdEq()
    {
        return this.idEq;
    }

    public void setIdEq(Integer idEq)
    {
        this.idEq = idEq;
    }

    @Column(name = "nombre",length = 45)
    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    @Column(name = "division",length = 45)
    public String getDivision()
    {
        return this.division;
    }

    public void setDivision(String division)
    {
        this.division = division;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "equipo")
    public Set<Jugador> getJugadors()
    {
        return this.jugadors;
    }

    public void setJugadors(Set<Jugador> jugadors)
    {
        this.jugadors = jugadors;
    }

	@Override
	public String toString() {
		return "Equipo [idEq=" + idEq + ", nombre=" + nombre + ", division=" + division + ", jugadors=" + jugadors
				+ "]";
	}

    
}
