package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.service.AutorService;

@RestController
@RequestMapping("/api/autor")
public class AutorController {
	@Autowired
	public AutorService autorService;
}
