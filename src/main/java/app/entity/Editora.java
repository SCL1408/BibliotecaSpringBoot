package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Editora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Este campo não pode ser nulo (nome)")
	private String nome;
	
	@NotNull(message = "Este campo não pode ser nulo (endereco)")
	private String endereco;
	
	@NotNull(message = "Este campo não pode ser nulo (telefone)")
	private String telefone;
	
	@OneToMany(mappedBy = "editora")//nome do objeto da entidade Livro	
	private List<Livro> livros;
}
