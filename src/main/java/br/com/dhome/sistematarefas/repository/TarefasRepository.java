package br.com.dhome.sistematarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dhome.sistematarefas.entities.TarefasEntitie;

@Repository
public interface TarefasRepository extends JpaRepository<TarefasEntitie, Long> {

}
