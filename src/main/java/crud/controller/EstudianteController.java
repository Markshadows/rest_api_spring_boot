package crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.excepcion.DatoNoEncontradoExcepcion;
import crud.modelo.EstudianteEntity;
import crud.service.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	EstudianteService service;

	@GetMapping
	public ResponseEntity<List<EstudianteEntity>> getAllEstudiantes() {
		List<EstudianteEntity> list = service.obtenerEstudiantes();

		return new ResponseEntity<List<EstudianteEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstudianteEntity> getStudentById(@PathVariable("id") Long id) throws DatoNoEncontradoExcepcion {
		EstudianteEntity entity = service.EstudianteById(id);

		return new ResponseEntity<EstudianteEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EstudianteEntity> createOrUpdateStudent(@Valid @RequestBody EstudianteEntity student)
			throws DatoNoEncontradoExcepcion {
		EstudianteEntity updated = service.createOrUpdateStudent(student);
		return new ResponseEntity<EstudianteEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteStudentById(@PathVariable("id") Long id) throws DatoNoEncontradoExcepcion {
		service.borrarEstudianteById(id);
		return HttpStatus.FORBIDDEN;
	}
}
