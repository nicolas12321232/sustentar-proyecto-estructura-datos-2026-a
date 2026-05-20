package parte_1_mi_primera_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parte_1_mi_primera_web.entity.Turno;
import parte_1_mi_primera_web.entity.EstadoTurno;
import parte_1_mi_primera_web.repository.TurnoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin(origins = "*")
public class TurnoController {

    @Autowired
    private TurnoRepository repository;

    //  Visualizar una lista de turnos (con datos básicos de persona, categoría y estado)
    @GetMapping
    public List<Turno> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Turno guardar(@RequestBody Turno turno) {
        if (turno.getEstado() == null) {
            turno.setEstado(EstadoTurno.RESERVADO); // Le ponemos un estado inicial por defecto si viene vacío
        }
        return repository.save(turno);
    }

    @PutMapping("/{id}/estado")
    public Turno cambiarEstado(@PathVariable Long id, @RequestParam EstadoTurno nuevoEstado) {
        Turno turno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
        turno.setEstado(nuevoEstado);
        return repository.save(turno);
    }
}