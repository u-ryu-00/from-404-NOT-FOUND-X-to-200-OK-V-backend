package kr.megaptera.F4T2.dtos;

public class WrongUserIdFormatErrorDto extends ErrorDto {
    public WrongUserIdFormatErrorDto() {
        super(1002, "아이디를 다시 확인해주세요.");
    }
}
