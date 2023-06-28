package kr.megaptera.F4T2.backdoor;

import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("backdoor")
@Transactional
public class BackdoorController {
    private final JdbcTemplate jdbcTemplate;

    public BackdoorController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("setup-database")
    public String setupDatabase() {
        jdbcTemplate.execute("DELETE FROM product");

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, description, image, name, price, quantity)" +
                " VALUES(1, '소음이 적은 레이저 기계식 키보드', 'https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80', '저소음 적축 레이저 기계식 키보드', 49000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, description, image, name, price, quantity)" +
                " VALUES(2, '거북이 인형', 'https://images.unsplash.com/photo-1488723905857-809bb9a2d21d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80', '귀여운 사이즈의 거북이 인형입니다!', 30000, 3)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, description, image, name, price, quantity)" +
                " VALUES(2, '엘모 인형', 'https://images.unsplash.com/photo-1614796918928-c92c79693e94?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80', '보고만 있어도 기분 좋아지는 엘모 인형입니다!', 60000, 4)"
        );

        return "OK";
    }
}
