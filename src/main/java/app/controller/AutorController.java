package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Autor;
import app.entity.Livro;
import app.service.AutorService;

@RestController
@RequestMapping("/api/autor")
public class AutorController {
	@Autowired
	public AutorService autorService;
	
	@GetMapping("/listall")
	public ResponseEntity<List<Autor>> listall(){
		try {
			return new ResponseEntity<List<Autor>>(this.autorService.listall(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Autor> findById(@PathVariable int id){
		try {
			Autor autor = this.autorService.findById(id);
			if(autor!=null)
				return new ResponseEntity<Autor>(autor, HttpStatus.FOUND);
			else
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		try {
			if(this.autorService.delete(id))
				return new ResponseEntity<String>("Registro deletado com sucesso", HttpStatus.FOUND);
			else
				return new ResponseEntity<String>("Não foi possível encontrar o item", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Autor autor){
		try {
			if(this.autorService.save(autor))
				return new ResponseEntity<String>("Registro criado com sucesso", HttpStatus.CREATED);
			return new ResponseEntity<String>("Não foi possível encontrar o item", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e, HttpStatus.BAD_REQUEST);
		}
	}
}
