package br.com.dhome.sistematarefas.exceptions.manipula;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.dhome.sistematarefas.dto.ErrorDto;
import br.com.dhome.sistematarefas.exceptions.IdNotFound;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipulaExceptions {

	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ErrorDto> idNotFound(IdNotFound e, HttpServletRequest request) {

		ErrorDto errorDto = new ErrorDto(Instant.now(), 404, "Id não encontrado na base de dados",
				request.getRequestURI(), e.getMessage());
		return ResponseEntity.status(404).body(errorDto);
	}

}
