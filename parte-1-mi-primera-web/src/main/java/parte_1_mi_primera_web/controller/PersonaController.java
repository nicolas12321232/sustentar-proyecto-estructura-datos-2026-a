package parte_1_mi_primera_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parte_1_mi_primera_web.entity.Persona;
import parte_1_mi_primera_web.repository.PersonaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin(origins = "*") // Esto es súper importante para que Axios no tenga errores de conexión luego
public class PersonaController {

    @Autowired
    private PersonaRepository repository;

    // Consultar todas las personas
    @GetMapping
    public List<Persona> listarTodas() {
        return repository.findAll();
    }

    // Registrar una persona
    @PostMapping
    public Persona guardar(@RequestBody Persona persona) {
        return repository.save(persona);
    }

    // Actualizar una persona
    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Long id, @RequestBody Persona persona) {
        persona.setId(id); // Aseguramos que actualice el registro correcto
        return repository.save(persona);
    }

    // Eliminar una persona
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}