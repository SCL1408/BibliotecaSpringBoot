package app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
	private int id;
	private String issn;
	private String titulo;
	private String sinopse;
	private int ano;
	private int numeroPaginas;
}
