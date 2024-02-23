package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Editora;
import app.service.EditoraService;

@RestController
@RequestMapping("/api/editora")
public class EditoraController {
	@Autowired
	public EditoraService editoraService;
	
	@GetMapping("/listall")
	public ResponseEntity<List<Editora>> listall(){
		try {
			return new ResponseEntity<List<Editora>>(this.editoraService.listall(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Editora> findById(@PathVariable int id){
		try {
			Editora editora = this.editoraService.findById(id);
			if(editora!=null)
				return new ResponseEntity<Editora>(editora, HttpStatus.FOUND);
			else
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		try {
			if(this.editoraService.delete(id))
				return new ResponseEntity<String>("Registro deletado com sucesso", HttpStatus.FOUND);
			else
				return new ResponseEntity<String>("Não foi possível encontrar o item", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Editora editora){
		try {
			if(this.editoraService.save(editora))
				return new ResponseEntity<String>("Registro criado com sucesso", HttpStatus.CREATED);
			return new ResponseEntity<String>("Não foi possível encontrar o item", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable int id, @RequestBody Editora novoEditora){
		try {
			if(this.editoraService.update(id, novoEditora))
				return new ResponseEntity<String>("Registro alterado com sucesso", HttpStatus.OK);
			return new ResponseEntity<String>("Não foi possível encontrar o item", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro: "+e, HttpStatus.BAD_REQUEST);
		}
	}
}
