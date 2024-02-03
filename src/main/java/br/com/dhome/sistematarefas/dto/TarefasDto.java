package br.com.dhome.sistematarefas.dto;

import java.util.Date;

public class TarefasDto {

	private String tipoTarefa;
	private String descricaoTarefa;
	private Date dataTarefa;
	private String statusTarefa;

	public TarefasDto(String tipoTarefa, String descricaoTarefa, Date dataTarefa, String statusTarefa) {
		this.tipoTarefa = tipoTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataTarefa = dataTarefa;
		this.statusTarefa = statusTarefa;
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
