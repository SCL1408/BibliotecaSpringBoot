package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Editora;

@Service
public class EditoraService {
	private List<Editora> lista;

	public EditoraService() {
		this.lista = new ArrayList<>();
		Editora editora1 = new Editora(1, "Editora ABC", "Rua ABC, 123", "123456789");
		this.lista.add(editora1);
		Editora editora2 = new Editora(2, "Editora XYZ", "Rua XYZ, 456", "987654321");
		this.lista.add(editora2);
		Editora editora3 = new Editora(3, "Editora 123", "Av. 123, 789", "456789123");
		this.lista.add(editora3);
		Editora editora4 = new Editora(4, "Editora QWERTY", "Av. QWERTY, 321", "789123456");
		this.lista.add(editora4);
		Editora editora5 = new Editora(5, "Editora Teste", "Rua Teste, 567", "234567890");
		this.lista.add(editora5);
		Editora editora6 = new Editora(6, "Editora Livro Bom", "Rua Livro Bom, 890", "876543210");
		this.lista.add(editora6);
		Editora editora7 = new Editora(7, "Editora Livro Novo", "Av. Livro Novo, 345", "345678912");
		this.lista.add(editora7);
		Editora editora8 = new Editora(8, "Editora Leitura", "Av. Leitura, 678", "678912345");
		this.lista.add(editora8);
		Editora editora9 = new Editora(9, "Editora Mundo", "Rua Mundo, 901", "901234567");
		this.lista.add(editora9);
		Editora editora10 = new Editora(10, "Editora Virtual", "Av. Virtual, 234", "567890123");
		this.lista.add(editora10);
	}
	
	public List<Editora> listall() {
		return this.lista;
	}

	public Editora findById(int id) {
		for (Editora editora : this.lista) {
			if (editora.getId() == id)
				return editora;
		}
		return null;
	}

	public boolean delete(int id) {
		for(Editora editora : this.lista) {
			if(editora.getId()==id) {
				this.lista.remove(editora);
				return true;
			}
		}
		return false;
	}

	public boolean save(Editora editora) {
		if (this.lista.add(editora))
			return true;
		return false;
	}
	
	public boolean update(int id, Editora novoEditora) {
		Editora editora = new Editora();
		int index;
		
		editora = findById(id);
		if(editora==null)
			return false;
		
		index = this.lista.indexOf(editora);

		this.lista.get(index).setId(novoEditora.getId());
		this.lista.get(index).setNome(novoEditora.getNome());
		this.lista.get(index).setEndereco(novoEditora.getEndereco());
		this.lista.get(index).setTelefone(novoEditora.getTelefone());
		
		return true;
	}
}
