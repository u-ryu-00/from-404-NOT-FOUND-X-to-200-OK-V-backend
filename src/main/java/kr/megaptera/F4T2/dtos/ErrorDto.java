package kr.megaptera.F4T2.dtos;

public class ErrorDto {
    private final Integer code;

    private final String message;

    public ErrorDto(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
