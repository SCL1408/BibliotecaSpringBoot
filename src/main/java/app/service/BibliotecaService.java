package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Autor;
import app.entity.Biblioteca;

@Service
public class BibliotecaService {
	private List<Biblioteca> lista;

	public BibliotecaService() {
		this.lista = new ArrayList<Biblioteca>();
		Biblioteca biblioteca1 = new Biblioteca(1, "Biblioteca Central", "123456789");
		this.lista.add(biblioteca1);
		Biblioteca biblioteca2 = new Biblioteca(2, "Biblioteca Municipal", "987654321");
		this.lista.add(biblioteca2);
		Biblioteca biblioteca3 = new Biblioteca(3, "Biblioteca Universitária", "456789123");
		this.lista.add(biblioteca3);
		Biblioteca biblioteca4 = new Biblioteca(4, "Biblioteca Infantil", "789123456");
		this.lista.add(biblioteca4);
		Biblioteca biblioteca5 = new Biblioteca(5, "Biblioteca Pública", "234567890");
		this.lista.add(biblioteca5);
		Biblioteca biblioteca6 = new Biblioteca(6, "Biblioteca Escolar", "876543210");
		this.lista.add(biblioteca6);
		Biblioteca biblioteca7 = new Biblioteca(7, "Biblioteca Digital", "345678912");
		this.lista.add(biblioteca7);
		Biblioteca biblioteca8 = new Biblioteca(8, "Biblioteca Nacional", "678912345");
		this.lista.add(biblioteca8);
		Biblioteca biblioteca9 = new Biblioteca(9, "Biblioteca Comunitária", "901234567");
		this.lista.add(biblioteca9);
		Biblioteca biblioteca10 = new Biblioteca(10, "Biblioteca Virtual", "567890123");
		this.lista.add(biblioteca10);
	}
	
	public List<Biblioteca> listall() {
		return this.lista;
	}

	public Biblioteca findById(int id) {
		for (Biblioteca biblioteca : this.lista) {
			if (biblioteca.getId() == id)
				return biblioteca;
		}
		return null;
	}
}
