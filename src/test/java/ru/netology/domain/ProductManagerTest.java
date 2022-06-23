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
    public void shouldFindById() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        int idToFind = 101;
        Product actual = manager.findById(idToFind);
        Product expected = second;
        assertEquals(actual, expected);
    }

    @Test
    public void shouldFindNothingById() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        int idToFind = 110;
        Product actual = manager.findById(idToFind);
        Product expected = null;
        assertEquals(actual, expected);
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
    public void shouldCheckNotFoundExceptionForWrongId() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        assertThrows(NotFoundException.class, () -> {
            manager.removeById(120);
        });
    }

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
    public void shouldCheckAlreadyExistsException() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        assertThrows(AlreadyExistsException.class, () -> {
            manager.add(first);
        });
    }

}
