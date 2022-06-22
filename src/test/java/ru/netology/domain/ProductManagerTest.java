package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductManager manager = new ProductManager();
    Product first = new Book(100, "Изучаем Java", 1500, "К.Сьерра, Б.Бейтс");
    Product second = new Book(101, "Совершенный код", 1000, "С.Макконнелл");
    Product third = new Smartphone(102, "Apple iPhone 13 Pro", 100_000, "Apple, Inc.");
    Product fourth = new Smartphone(103, "Apple iPad Air 4", 80_000, "Apple, Inc.");


    @Test
    public void shouldAddAllProducts() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{first, second, third, fourth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddFirstAndLastProducts() {
        manager.add(first);
        manager.add(fourth);
        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{first, fourth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddNoProducts() {
        Product[] actual = manager.findAll();
        Product[] expected = new Product[0];
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveById() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        int idToRemove = 102;
        manager.removeById(idToRemove);
        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{first, second, fourth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindOneByText() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        Product[] actual = manager.searchBy("код");
        Product[] expected = new Product[]{second};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindTwoByText() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        Product[] actual = manager.searchBy("App");
        Product[] expected = new Product[]{third, fourth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindNothingByText() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        Product[] actual = manager.searchBy("Z");
        Product[] expected = new Product[0];
        assertArrayEquals(actual, expected);
    }

}
