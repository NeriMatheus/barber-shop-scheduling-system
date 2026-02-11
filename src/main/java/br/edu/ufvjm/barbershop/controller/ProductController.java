package br.edu.ufvjm.barbershop.controller;

import br.edu.ufvjm.barbershop.model.Product;
import br.edu.ufvjm.barbershop.service.BarbershopSystem;

import java.util.List;

public class ProductController {

    private final SystemService system;

    public ProductController(SystemService system) {
        this.system = system;
    }

    public void create(Product product) {
        if (product == null) {
            return;
        }

        system.registerProduct(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getPrice(),
                product.getQuantity()
        );
    }

    public Product findById(String id) {
        if (id == null) {
            return null;
        }

        for (Product product : system.getProducts()) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> listAll() {
        return system.getProducts();
    }

    public boolean sell(String id, int quantity) {
        if (id == null || quantity <= 0) {
            return false;
        }

        return system.sellProduct(id, quantity);
    }

    public void restock(String id, int quantity) {
        if (id == null || quantity <= 0) {
            return;
        }

        system.receiveFromSupplier(id, quantity);
    }
}
