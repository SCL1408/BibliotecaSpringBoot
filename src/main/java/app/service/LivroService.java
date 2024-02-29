package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Livro;
import app.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository livroRepository;
	
	public List<Livro> listall() {
		return this.livroRepository.findAll();
	}

	public Livro findById(long id) {
		return this.livroRepository.findById(id).get();
	}

	public void delete(long id) {
		this.livroRepository.deleteById(id);
	}

	public void save(Livro livro) {
		this.livroRepository.save(livro);
	}
	
	public void update(long id, Livro novoLivro) {
		novoLivro.setId(id);
		this.livroRepository.save(novoLivro);
	}
}
