package crud.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ESTUDIANTE")
public class EstudianteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "appaterno")
	private String appaterno;

	@Column(name = "apmaterno")
	private String apmaterno;

	@NotBlank
	@Column(name = "email_id", nullable = false, length = 100)
	private String emailId;

	@Override
	public String toString() {
		return "EstudianteEntity [id=" + id + ", nombre=" + nombre + ", appaterno=" + appaterno + ", apmaterno="
				+ apmaterno + ", emailId=" + emailId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAppaterno() {
		return appaterno;
	}

	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}

	public String getApmaterno() {
		return apmaterno;
	}

	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
