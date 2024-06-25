package dio.me.desafio_santander_api_deploy_2024.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
