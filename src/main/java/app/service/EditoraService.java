package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Editora;
import app.repository.EditoraRepository;

@Service
public class EditoraService {
	@Autowired
	private EditoraRepository editoraRepository;
	
	public List<Editora> listall() {
		return this.editoraRepository.findAll();
	}

	public Editora findById(long id) {
		return this.editoraRepository.findById(id).get();
	}

	public void delete(long id) {
		this.editoraRepository.deleteById(id);
	}

	public void save(Editora editora) {
		this.editoraRepository.save(editora);
	}
	
	public void update(long id, Editora novoEditora) {
		novoEditora.setId(id);
		this.editoraRepository.save(novoEditora);
	}
}
