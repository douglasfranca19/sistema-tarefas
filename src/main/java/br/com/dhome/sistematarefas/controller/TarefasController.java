package br.com.dhome.sistematarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dhome.sistematarefas.entities.TarefasEntitie;
import br.com.dhome.sistematarefas.service.TarefasService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefasController {

	@Autowired
	private TarefasService service;

	@PostMapping(value = "/insere")
	public ResponseEntity<TarefasEntitie> addTarefas(@RequestBody TarefasEntitie tarefasEntitie) {
		return ResponseEntity.ok().body(service.addTarefas(tarefasEntitie));

	}

	@GetMapping(value = "/busca-todos")
	public ResponseEntity<List<TarefasEntitie>> findAll() {
		return ResponseEntity.ok().body(service.findAll());

	}

	@DeleteMapping(value = "/deleta-tdos")
	public void deleteAllTarefas(TarefasEntitie tarefasEntitie) {
		service.deleteAllTarefas(tarefasEntitie);
	}

}
