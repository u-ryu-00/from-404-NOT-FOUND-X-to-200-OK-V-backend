package kr.megaptera.F4T2.dtos;

public class InvalidNameLengthErrorDto extends ErrorDto {
    public InvalidNameLengthErrorDto() {
        super(1001, "이름을 다시 확인해주세요.");
    }
}
