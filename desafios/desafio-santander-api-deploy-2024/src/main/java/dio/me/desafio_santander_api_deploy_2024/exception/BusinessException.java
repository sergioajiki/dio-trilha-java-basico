package dio.me.desafio_santander_api_deploy_2024.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
