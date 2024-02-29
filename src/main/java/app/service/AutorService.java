package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Autor;
import app.repository.AutorRepository;

@Service
public class AutorService {
	@Autowired
	private AutorRepository autorRepository;
	
	public List<Autor> listall() {
		return this.autorRepository.findAll();
	}

	public Autor findById(long id) {
		return this.autorRepository.findById(id).get();
	}

	public void delete(long id) {
		this.autorRepository.deleteById(id);
	}

	public void save(Autor autor) {
		this.autorRepository.save(autor);
	}
	
	public void update(long id, Autor novoAutor) {
		novoAutor.setId(id);
		this.autorRepository.save(novoAutor);
	}
}
