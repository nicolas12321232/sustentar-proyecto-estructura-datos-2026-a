package parte_1_mi_primera_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parte_1_mi_primera_web.entity.CategoriaTurno;
import parte_1_mi_primera_web.repository.CategoriaTurnoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaTurnoController {

    @Autowired
    private CategoriaTurnoRepository repository;

    @GetMapping
    public List<CategoriaTurno> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public CategoriaTurno guardar(@RequestBody CategoriaTurno categoria) {
        return repository.save(categoria);
    }

    @PutMapping("/{id}")
    public CategoriaTurno actualizar(@PathVariable Long id, @RequestBody CategoriaTurno categoria) {
        categoria.setId(id);
        return repository.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}