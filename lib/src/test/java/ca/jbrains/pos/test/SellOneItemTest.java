package ca.jbrains.pos.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SellOneItemTest {
    @Test
    void productFound() {
        final Sale sale = new Sale();
        final Display display = new Display();

        sale.onBarcode("12345");

        Assertions.assertEquals("$7.95", display.getText());
    }

    @Test
    void anotherProductFound() {
        final Sale sale = new Sale();
        final Display display = new Display();

        sale.onBarcode("23456");

        Assertions.assertEquals("$12.50", display.getText());
    }

    public static class Sale {
        public void onBarcode(String barcode) {
        }
    }

    public static class Display {
        public String getText() {
            return "$7.95";
        }
    }
}
