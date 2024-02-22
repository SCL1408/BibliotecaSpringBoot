package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Autor;
import app.entity.Biblioteca;

@Service
public class AutorService {
	private List<Autor> lista;

	public AutorService() {
		this.lista = new ArrayList<Autor>();
		Autor autor1 = new Autor(1, "Pedro João", "12345678900", 25);
		this.lista.add(autor1);
		Autor autor2 = new Autor(2, "Ana Silva", "98765432100", 30);
		this.lista.add(autor2);
		Autor autor3 = new Autor(3, "Carlos Souza", "45678912300", 40);
		this.lista.add(autor3);
		Autor autor4 = new Autor(4, "Mariana Oliveira", "78912345600", 28);
		this.lista.add(autor4);
		Autor autor5 = new Autor(5, "José Santos", "23456789000", 35);
		this.lista.add(autor5);
		Autor autor6 = new Autor(6, "Luiza Costa", "87654321000", 45);
		this.lista.add(autor6);
		Autor autor7 = new Autor(7, "Fernando Pereira", "34567891200", 33);
		this.lista.add(autor7);
		Autor autor8 = new Autor(8, "Amanda Rodrigues", "67891234500", 27);
		this.lista.add(autor8);
		Autor autor9 = new Autor(9, "Rafaela Nunes", "90123456700", 32);
		this.lista.add(autor9);
		Autor autor10 = new Autor(10, "Lucas Martins", "56789012300", 38);
		this.lista.add(autor10);
	}
}
