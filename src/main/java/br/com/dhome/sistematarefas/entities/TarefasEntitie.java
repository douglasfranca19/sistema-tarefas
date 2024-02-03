package br.com.dhome.sistematarefas.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefas")
public class TarefasEntitie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo_tarefa", nullable = false, length = 500)
	private String tipoTarefa;

	@Column(name = "descricao_tarefa", nullable = false, length = 2000)
	private String descricaoTarefa;

	@Column(name = "data_tarefa", nullable = false, length = 500)
	private Date dataTarefa;

	@Column(name = "status_tarefa", nullable = false, length = 500)
	private String statusTarefa;

	public TarefasEntitie(String tipoTarefa, String descricaoTarefa, Date dataTarefa, String statusTarefa) {
		this.tipoTarefa = tipoTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataTarefa = dataTarefa;
		this.statusTarefa = statusTarefa;
	}

	public TarefasEntitie() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(String tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public Date getDataTarefa() {
		return dataTarefa;
	}

	public void setDataTarefa(Date dataTarefa) {
		this.dataTarefa = dataTarefa;
	}

	public String getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}

}
