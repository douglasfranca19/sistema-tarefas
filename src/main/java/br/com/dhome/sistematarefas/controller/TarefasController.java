package br.com.dhome.sistematarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dhome.sistematarefas.dto.TarefasEntradaDto;
import br.com.dhome.sistematarefas.dto.TarefasRetornoDto;
import br.com.dhome.sistematarefas.entities.TarefasEntitie;
import br.com.dhome.sistematarefas.service.TarefasService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefasController {

	@Autowired
	private TarefasService service;

	@PostMapping(value = "/insere")
	public ResponseEntity<TarefasEntitie> addTarefas(@RequestBody TarefasEntradaDto tarefasDto) {

		TarefasEntitie tarefasEntitie = new TarefasEntitie();

		tarefasEntitie.setDescricaoTarefa(tarefasDto.getDescricaoTarefa());
		tarefasEntitie.setDataTarefa(tarefasDto.getDataTarefa());
		tarefasEntitie.setTipoTarefa(tarefasDto.getTipoTarefa());
		tarefasEntitie.setStatusTarefa(tarefasDto.getStatusTarefa());

		return ResponseEntity.ok().body(service.addTarefas(tarefasEntitie));

	}

	@GetMapping(value = "/busca-id/{id}")
	public ResponseEntity<TarefasRetornoDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));

	}

	@GetMapping(value = "/busca-todos")
	public ResponseEntity<List<TarefasRetornoDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll());

	}

	@DeleteMapping(value = "/deleta-todos")
	public void deleteAllTarefas(TarefasEntitie tarefasEntitie) {
		service.deleteAllTarefas(tarefasEntitie);
	}

	@PutMapping(value = "/atualiza-tarefa/{id}")
	public ResponseEntity<TarefasEntitie> atualizaTarefa(@PathVariable Long id,
			@RequestBody TarefasEntradaDto tarefasDto) {

		TarefasEntitie tarefasEntitie = new TarefasEntitie();

		tarefasEntitie.setDescricaoTarefa(tarefasDto.getDescricaoTarefa());
		tarefasEntitie.setDataTarefa(tarefasDto.getDataTarefa());
		tarefasEntitie.setTipoTarefa(tarefasDto.getTipoTarefa());
		tarefasEntitie.setStatusTarefa(tarefasDto.getStatusTarefa());

		return ResponseEntity.ok().body(service.atualizaTarefa(id, tarefasEntitie));

	}

}
