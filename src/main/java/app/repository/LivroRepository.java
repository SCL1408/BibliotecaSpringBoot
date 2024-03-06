package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Biblioteca;
import app.entity.Editora;
import app.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	public List<Livro> findByTitulo(String titulo);
	
	public List<Livro> findByEditora(Editora editora);
	
	public List<Livro> findByBibliotecas(Biblioteca biblioteca);
}
