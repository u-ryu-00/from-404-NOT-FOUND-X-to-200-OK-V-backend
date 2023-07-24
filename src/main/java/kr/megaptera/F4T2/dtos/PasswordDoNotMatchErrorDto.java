package kr.megaptera.F4T2.dtos;

public class PasswordDoNotMatchErrorDto extends ErrorDto {
    public PasswordDoNotMatchErrorDto() {
        super(1004, "비밀번호가 일치하지 않습니다.");
    }
}
