package parte_1_mi_primera_web.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estado;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "categoria_turno_id")
    private CategoriaTurno categoriaTurno;

    // --- Getters y Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public CategoriaTurno getCategoriaTurno() {
        return categoriaTurno;
    }

    public void setCategoriaTurno(CategoriaTurno categoriaTurno) {
        this.categoriaTurno = categoriaTurno;
    }
}