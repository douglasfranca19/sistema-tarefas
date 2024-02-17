package br.com.dhome.sistematarefas.exceptions;

public class IdNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdNotFound(String message) {
		super(message);
	}

}
