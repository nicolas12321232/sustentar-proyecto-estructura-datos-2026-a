package parte_1_mi_primera_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parte_1_mi_primera_web.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}