package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
			return new ResponseEntity<List<Editora>>(this.editoraService.listall(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
