package br.com.dhome.sistematarefas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dhome.sistematarefas.entities.TarefasEntitie;
import br.com.dhome.sistematarefas.repository.TarefasRepository;
import jakarta.transaction.Transactional;

@Service
public class TarefasService {

	@Autowired
	private TarefasRepository tarefas;

	public TarefasEntitie addTarefas(TarefasEntitie tarefasEntitie) {
		return tarefas.save(tarefasEntitie);

	}

	public Optional<TarefasEntitie> findById(Long id) {
		return tarefas.findById(id);

	}

	public List<TarefasEntitie> findAll() {
		return tarefas.findAll();
	}

	public void deleteAllTarefas(TarefasEntitie tarefasEntitie) {
		tarefas.deleteAll();
	}

	@Transactional
	public TarefasEntitie atualizaTarefa(Long id, TarefasEntitie tarefasEntitie) {

		TarefasEntitie tEntitie = tarefas.getReferenceById(id);
		atulizaTarefa(tEntitie, tarefasEntitie);
		return tarefas.save(tEntitie);

	}

	private void atulizaTarefa(TarefasEntitie tEntitie, TarefasEntitie tarefasEntitie) {

		tEntitie.setTipoTarefa(tarefasEntitie.getTipoTarefa());
		tEntitie.setDescricaoTarefa(tarefasEntitie.getDescricaoTarefa());
		tEntitie.setDataTarefa(tarefasEntitie.getDataTarefa());
		tEntitie.setStatusTarefa(tarefasEntitie.getStatusTarefa());
	}

}
