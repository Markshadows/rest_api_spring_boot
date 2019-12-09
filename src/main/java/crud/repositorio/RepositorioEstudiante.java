package crud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.modelo.EstudianteEntity;

@Repository
public interface RepositorioEstudiante extends JpaRepository<EstudianteEntity, Long>{

}
