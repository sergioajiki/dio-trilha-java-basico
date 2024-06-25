package dio.me.desafio_santander_api_deploy_2024.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralControllerAdvice {
    private final Logger LOOGER = LoggerFactory.getLogger(GeneralControllerAdvice.class);

}
