package crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.excepcion.DatoNoEncontradoExcepcion;
import crud.modelo.EstudianteEntity;
import crud.repositorio.RepositorioEstudiante;

@Service
public class EstudianteService {

	@Autowired
	RepositorioEstudiante repositorio;

	public List<EstudianteEntity> obtenerEstudiantes() {
		List<EstudianteEntity> listaEstudiantes = repositorio.findAll();

		if (listaEstudiantes.size() > 0) {
			return listaEstudiantes;
		}

		return new ArrayList<EstudianteEntity>();
	}

	public EstudianteEntity EstudianteById(Long id) throws DatoNoEncontradoExcepcion {
		Optional<EstudianteEntity> estudiante = repositorio.findById(id);

		if (estudiante.isPresent()) {
			return estudiante.get();
		} else {
			throw new DatoNoEncontradoExcepcion("No existe estudiante con id: ", id);
		}
	}

	public EstudianteEntity createOrUpdateStudent(EstudianteEntity entity) throws DatoNoEncontradoExcepcion {

		if (entity.getId() != null) {
			Optional<EstudianteEntity> student = repositorio.findById(entity.getId());

			if (student.isPresent()) {
				EstudianteEntity newEntity = student.get();
				newEntity.setEmailId(entity.getEmailId());
				newEntity.setNombre(entity.getNombre());
				newEntity.setAppaterno(entity.getAppaterno());
				newEntity.setApmaterno(entity.getApmaterno());

				newEntity = repositorio.save(newEntity);

				return newEntity;
			} else {
				entity = repositorio.save(entity);

				return entity;
			}
		}

		else {
			entity = repositorio.save(entity);
			return entity;
		}
	}

	public void borrarEstudianteById(Long id) throws DatoNoEncontradoExcepcion {
		Optional<EstudianteEntity> student = repositorio.findById(id);

		if (student.isPresent()) {
			repositorio.deleteById(id);
		} else {
			throw new DatoNoEncontradoExcepcion("No existe el estudiante con id ", id);
		}
	}
}
