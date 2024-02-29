package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Biblioteca;
import app.repository.BibliotecaRepository;

@Service
public class BibliotecaService {
	@Autowired
	private BibliotecaRepository bibliotecaRepository;
	
	public List<Biblioteca> listall() {
		return this.bibliotecaRepository.findAll();
	}

	public Biblioteca findById(long id) {
		return this.bibliotecaRepository.findById(id).get();
	}

	public void delete(long id) {
		this.bibliotecaRepository.deleteById(id);
	}

	public void save(Biblioteca biblioteca) {
		this.bibliotecaRepository.save(biblioteca);
	}
	
	public void update(long id, Biblioteca novoBiblioteca) {
		novoBiblioteca.setId(id);
		this.bibliotecaRepository.save(novoBiblioteca);
	}
}
