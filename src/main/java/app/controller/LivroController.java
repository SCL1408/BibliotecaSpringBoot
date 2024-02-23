package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Livro;
import app.service.LivroService;

@RestController
@RequestMapping("/api/livro")
public class LivroController {
	@Autowired
	public LivroService livroService;
	
	@GetMapping("/listall")
	public ResponseEntity<List<Livro>> listall(){
		try {
			return new ResponseEntity<List<Livro>>(this.livroService.listall(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Livro> findById(@PathVariable int id){
		try {
			Livro livro = this.livroService.findById(id);
			if(livro!=null)
				return new ResponseEntity<Livro>(livro, HttpStatus.FOUND);
			else
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		try {
			if(this.livroService.delete(id))
				return new ResponseEntity<String>("Registro deletado com sucesso", HttpStatus.FOUND);
			else
				return new ResponseEntity<String>("Não foi possível encontrar o item", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e, HttpStatus.BAD_REQUEST);
		}
	}
}
