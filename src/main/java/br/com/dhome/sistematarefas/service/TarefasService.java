package br.com.dhome.sistematarefas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dhome.sistematarefas.dto.TarefasRetornoDto;
import br.com.dhome.sistematarefas.entities.TarefasEntitie;
import br.com.dhome.sistematarefas.exceptions.IdNotFound;
import br.com.dhome.sistematarefas.repository.TarefasRepository;
import jakarta.transaction.Transactional;

@Service
public class TarefasService {

	@Autowired
	private TarefasRepository tarefas;

	public TarefasEntitie addTarefas(TarefasEntitie tarefasEntitie) {
		return tarefas.save(tarefasEntitie);

	}

	public TarefasRetornoDto findById(Long id) {

		Optional<TarefasEntitie> tarefasEntitie = tarefas.findById(id);

		if (tarefasEntitie.isPresent()) {
			TarefasEntitie taEntitie = tarefasEntitie.get();
			TarefasRetornoDto retornoDto = new TarefasRetornoDto();
			retornoDto.setId(taEntitie.getId());
			retornoDto.setTipoTarefa(taEntitie.getTipoTarefa());
			retornoDto.setDescricaoTarefa(taEntitie.getDescricaoTarefa());
			retornoDto.setDataTarefa(taEntitie.getDataTarefa());
			retornoDto.setStatusTarefa(taEntitie.getStatusTarefa());

			return retornoDto;
		} else {
			throw new IdNotFound("Dados não encontrados na base de dados");
		}

	}

	public List<TarefasRetornoDto> findAll() {

		List<TarefasEntitie> entities = tarefas.findAll();
		return entities.stream().map(entitiess -> {
			TarefasRetornoDto tarefasRetornoDto = new TarefasRetornoDto();
			tarefasRetornoDto.setId(entitiess.getId());
			tarefasRetornoDto.setTipoTarefa(entitiess.getTipoTarefa());
			tarefasRetornoDto.setDataTarefa(entitiess.getDataTarefa());
			tarefasRetornoDto.setDescricaoTarefa(entitiess.getDescricaoTarefa());
			tarefasRetornoDto.setStatusTarefa(entitiess.getStatusTarefa());
			return tarefasRetornoDto;
		}).collect(Collectors.toList());
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
