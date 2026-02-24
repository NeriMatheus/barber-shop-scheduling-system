package br.edu.ufvjm.barbershop.controller;

import br.edu.ufvjm.barbershop.model.Product;

public class ProductController {

    public ProductController() {
    }

    public void restock(Product product, int quantity) {
        if (product == null)
            throw new IllegalArgumentException("Product cannot be null.");

        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be positive.");

        product.addQuantity(quantity);
    }

    public void sell(Product product, int quantity) {
        if (product == null)
            throw new IllegalArgumentException("Product cannot be null.");

        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be positive.");

        product.addQuantity(-quantity);
    }
}