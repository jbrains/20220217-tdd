package ca.jbrains.pos.test;

import ca.jbrains.pos.Catalog;
import ca.jbrains.pos.Display;
import ca.jbrains.pos.Sale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SellMultipleItemsTest {
    @Test
    void happyPath() {
        final Display display = new Display();
        final Sale sale = new Sale(new Catalog(Map.of(
                "12345", 795,
                "23456", 895,
                "34567", 800
        )), display);

        sale.onBarcode("12345");
        Assertions.assertEquals("$7.95", display.getText());
        sale.onBarcode("23456");
        Assertions.assertEquals("$8.95", display.getText());
        sale.onBarcode("34567");
        Assertions.assertEquals("$8.00", display.getText());
        sale.onTotal();

        Assertions.assertEquals("Total: $24.90", display.getText());
    }
}
