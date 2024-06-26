package dio.me.desafio_santander_api_deploy_2024.exception;

public class NotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public NotFoundException(String message) {
        super(message);
    }
}
