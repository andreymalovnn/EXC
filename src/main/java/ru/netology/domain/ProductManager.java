package ru.netology.domain;

public class ProductManager {
    private Product[] products = new Product[0];


    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id " + id + " is not found");
        } else {
            Product[] tmp = new Product[products.length - 1];
            int index = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[index] = product;
                    index++;
                }
            }
            products = tmp;
        }
    }

    public void add(Product product) {
        if (findById(product.getId()) == product) {
            throw new AlreadyExistsException("Element with id " + product.getId() + " already exists");
        } else {
            Product[] tmp = new Product[products.length + 1];
            System.arraycopy(products, 0, tmp, 0, products.length);
            tmp[tmp.length - 1] = product;
            products = tmp;
        }
    }

}
