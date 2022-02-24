package ca.jbrains.pos.test;

import ca.jbrains.pos.Catalog;
import ca.jbrains.pos.Display;
import ca.jbrains.pos.Sale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SellOneItemTest {
    @Test
    void productFound() {
        final Display display = new Display();
        final Sale sale = new Sale(new Catalog(null,
                Map.of("12345", 795, "23456", 1250)), display);

        sale.onBarcode("12345");

        Assertions.assertEquals("$7.95", display.getText());
    }

    @Test
    void anotherProductFound() {
        final Display display = new Display();
        final Sale sale = new Sale(new Catalog(null,
                Map.of("12345", 795, "23456", 1250)), display);

        sale.onBarcode("23456");

        Assertions.assertEquals("$12.50", display.getText());
    }

    @Test
    void productNotFound() {
        final Display display = new Display();
        final Sale sale = new Sale(new Catalog(Map.of(), Map.of()), display);

        sale.onBarcode("99999");

        Assertions.assertEquals("Product not found: 99999", display.getText());
    }

    @Test
    void empty() {
        final Display display = new Display();
        final Sale sale = new Sale(new Catalog(Map.of(), Map.of()), display);

        sale.onBarcode("");

        Assertions.assertEquals("Scanning error: empty barcode", display.getText());
    }
}
