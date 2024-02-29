package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull(message = "Este campo não pode ser nulo (nome)")
	private String issn;
	@NotNull(message = "Este campo não pode ser nulo (nome)")
	private String titulo;
	@NotNull(message = "Este campo não pode ser nulo (nome)")
	private String sinopse;
	@NotNull(message = "Este campo não pode ser nulo (nome)")
	private int ano;
	@NotNull(message = "Este campo não pode ser nulo (nome)")
	private int numeroPaginas;
}
