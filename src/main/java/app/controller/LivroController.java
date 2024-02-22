package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.service.LivroService;

@RestController
@RequestMapping("/api/editora")
public class LivroController {
	@Autowired
	public LivroService livroautor;
}
