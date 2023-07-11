package kr.megaptera.F4T2.controllers;

import kr.megaptera.F4T2.dtos.ProductDto;
import kr.megaptera.F4T2.dtos.ProductsDto;
import kr.megaptera.F4T2.dtos.UpdateProductDto;
import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.services.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductsDto list(
            @RequestParam(required = false, defaultValue = "1") Integer page
    ) {
        List<ProductDto> productDtos =
                productService.list(page)
                        .stream()
                        .map(product -> product.toDto())
                        .collect(Collectors.toList());

        int totalPages = productService.pages();

        return new ProductsDto(productDtos, totalPages);
    }

    @PatchMapping("/{id}")
    public Long update(
            @PathVariable Long id, @RequestBody UpdateProductDto updateProductDto
    ) {
        return productService.update(id, updateProductDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/{id}")
    public ProductDto product(
            @PathVariable("id") Long id
    ) {
        Product product = productService.detail(id);

        return product.toDto();
    }
}
