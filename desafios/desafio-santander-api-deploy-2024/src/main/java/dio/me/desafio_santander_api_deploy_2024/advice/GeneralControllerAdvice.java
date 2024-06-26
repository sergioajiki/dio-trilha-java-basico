package dio.me.desafio_santander_api_deploy_2024.advice;

import dio.me.desafio_santander_api_deploy_2024.exception.NotFoundException;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralControllerAdvice {
    private final Logger LOOGER = LoggerFactory.getLogger(GeneralControllerAdvice.class);

    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundException(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
