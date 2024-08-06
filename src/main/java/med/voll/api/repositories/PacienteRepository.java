package med.voll.api.repositories;

import med.voll.api.domains.models.Paciente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> { }
