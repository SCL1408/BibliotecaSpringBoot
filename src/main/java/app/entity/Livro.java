package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("livros")//nome do objeto lista na entidade Editora
	private Editora editora;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="autor_livro",
			joinColumns = @JoinColumn(name="idLivro"), 
			inverseJoinColumns = @JoinColumn(name="idAutor")
			)
	private List<Autor> autores;
	
	@ManyToMany
	@JoinTable(
			name="biblioteca_livro",
			joinColumns=@JoinColumn(name="idLivro"),
			inverseJoinColumns=@JoinColumn(name="idBiblioteca"))
	private List<Biblioteca> bibliotecas;
}
