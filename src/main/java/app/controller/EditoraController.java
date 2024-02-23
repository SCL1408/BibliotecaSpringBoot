package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Editora;
import app.entity.Livro;
import app.service.EditoraService;

@RestController
@RequestMapping("/api/editora")
public class EditoraController {
	@Autowired
	public EditoraService editoraService;
	
	@GetMapping("/listall")
	public ResponseEntity<List<Editora>> listall(){
		try {
			return new ResponseEntity<List<Editora>>(this.editoraService.listall(), HttpStatus.CREATED);
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
}
