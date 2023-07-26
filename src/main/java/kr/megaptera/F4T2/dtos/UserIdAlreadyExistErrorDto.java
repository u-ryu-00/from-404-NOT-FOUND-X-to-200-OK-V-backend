package kr.megaptera.F4T2.dtos;

public class UserIdAlreadyExistErrorDto extends ErrorDto {
    public UserIdAlreadyExistErrorDto() {
        super(1000, "해당 아이디는 사용할 수 없습니다.");
    }
}
