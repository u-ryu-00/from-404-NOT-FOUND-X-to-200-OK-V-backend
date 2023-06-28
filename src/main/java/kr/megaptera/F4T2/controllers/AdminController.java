package kr.megaptera.F4T2.controllers;

import jakarta.validation.Valid;
import kr.megaptera.F4T2.dtos.RegisterProductDto;
import kr.megaptera.F4T2.dtos.RegisterProductResultDto;
import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.services.RegisterProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    private final RegisterProductService registerProductService;

    public AdminController(RegisterProductService registerProductService) {
        this.registerProductService = registerProductService;
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterProductResultDto registerProduct(
            @Valid @RequestBody RegisterProductDto registerProductDto
    ) {
        Product product = registerProductService.register(
                registerProductDto.getProductId(),
                registerProductDto.getName(),
                registerProductDto.getDescription(),
                registerProductDto.getImage(),
                registerProductDto.getPrice(),
                registerProductDto.getQuantity()
        );
        return product.toRegisterProductResultDto();
    }
}
