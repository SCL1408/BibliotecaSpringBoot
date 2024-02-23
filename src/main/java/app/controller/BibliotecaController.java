package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Biblioteca;
import app.service.BibliotecaService;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {
	@Autowired
	public BibliotecaService bibliotecaService;
	
	@GetMapping("/listall")
	public ResponseEntity<List<Biblioteca>> listall(){
		try {
			return new ResponseEntity<List<Biblioteca>>(this.bibliotecaService.listall(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
