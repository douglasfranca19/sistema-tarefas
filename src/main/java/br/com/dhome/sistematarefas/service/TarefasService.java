package br.com.dhome.sistematarefas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dhome.sistematarefas.entities.TarefasEntitie;
import br.com.dhome.sistematarefas.repository.TarefasRepository;

@Service
public class TarefasService {

	@Autowired
	private TarefasRepository tarefas;

	public TarefasEntitie addTarefas(TarefasEntitie tarefasEntitie) {
		return tarefas.save(tarefasEntitie);

	}

	public List<TarefasEntitie> findAll() {
		return tarefas.findAll();
	}

	public void deleteAllTarefas(TarefasEntitie tarefasEntitie) {
		tarefas.deleteAll();
	}

}
