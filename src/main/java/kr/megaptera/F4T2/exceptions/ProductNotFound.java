package kr.megaptera.F4T2.exceptions;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(Long productId) {
        super("Product Not Found (productId: " + productId + ")");
    }
}
