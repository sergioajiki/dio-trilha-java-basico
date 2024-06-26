package dio.me.desafio_santander_api_deploy_2024.exception;

public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public BusinessException(String message) {
        super(message);
    }
}
