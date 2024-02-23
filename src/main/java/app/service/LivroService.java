package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Livro;

@Service
public class LivroService {
	private List<Livro> lista;

	public LivroService() {
		this.lista = new ArrayList<>();
		Livro livro1 = new Livro(1, "978-85-221-1467-7", "O Senhor dos Anéis",
				"Uma grande aventura épica de J.R.R. Tolkien.", 1954, 1178);
		this.lista.add(livro1);
		Livro livro2 = new Livro(2, "978-85-8044-278-5", "Harry Potter e a Pedra Filosofal",
				"O primeiro livro da saga de J.K. Rowling.", 1997, 223);
		this.lista.add(livro2);
		Livro livro3 = new Livro(3, "978-85-5594-028-2", "Cem Anos de Solidão",
				"Uma obra-prima de Gabriel García Márquez.", 1967, 457);
		this.lista.add(livro3);
		Livro livro4 = new Livro(4, "978-85-01-02114-0", "A Revolução dos Bichos",
				"Um clássico de George Orwell sobre uma fazenda onde os animais assumem o controle.", 1945, 157);
		this.lista.add(livro4);
		Livro livro5 = new Livro(5, "978-85-366-1671-8", "A Culpa é das Estrelas",
				"Uma história emocionante de John Green sobre amor e superação.", 2012, 288);
		this.lista.add(livro5);
		Livro livro6 = new Livro(6, "978-85-221-1077-8", "1984",
				"Um dos romances mais famosos de George Orwell sobre uma sociedade distópica.", 1949, 336);
		this.lista.add(livro6);
		Livro livro7 = new Livro(7, "978-85-359-1452-8", "Dom Casmurro",
				"Um clássico de Machado de Assis sobre ciúmes e traição.", 1899, 256);
		this.lista.add(livro7);
		Livro livro8 = new Livro(8, "978-85-220-1713-3", "Crime e Castigo",
				"Um dos principais trabalhos de Fiódor Dostoiévski sobre crime e redenção.", 1866, 589);
		this.lista.add(livro8);
		Livro livro9 = new Livro(9, "978-85-359-1365-1", "Memórias Póstumas de Brás Cubas",
				"Um romance satírico de Machado de Assis sobre a vida após a morte.", 1881, 240);
		this.lista.add(livro9);
		Livro livro10 = new Livro(10, "978-85-67191-46-0", "O Pequeno Príncipe",
				"Um clássico de Antoine de Saint-Exupéry sobre a amizade e a busca pelo significado da vida.", 1943,
				96);
		this.lista.add(livro10);
	}

	public List<Livro> listall() {
		return this.lista;
	}

	public Livro findById(int id) {
		for (Livro livro : this.lista) {
			if (livro.getId() == id)
				return livro;
		}
		return null;
	}

	public boolean delete(int id) {
		for (Livro livro : this.lista) {
			if (livro.getId() == id) {
				this.lista.remove(livro);
				return true;
			}
		}
		return false;
	}

	public boolean save(Livro livro) {
		if (this.lista.add(livro))
			return true;
		return false;
	}
	
	public boolean update(int id, Livro novoLivro) {
		Livro livro = new Livro();
		int index;
		
		livro = findById(id);
		if(livro==null)
			return false;
		
		index = this.lista.indexOf(livro);

		this.lista.get(index).setAno(novoLivro.getAno());
		this.lista.get(index).setId(novoLivro.getId());
		this.lista.get(index).setNumeroPaginas(novoLivro.getNumeroPaginas());
		this.lista.get(index).setIssn(novoLivro.getIssn());
		this.lista.get(index).setSinopse(novoLivro.getSinopse());
		this.lista.get(index).setTitulo(novoLivro.getTitulo());
		
		return true;
	}
}
