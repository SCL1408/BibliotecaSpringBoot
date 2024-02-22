package app.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {
	private int id;
	private String issn;
	private String titulo;
	private String sinopse;
	private int ano;
	private int numeroPaginas;
}
