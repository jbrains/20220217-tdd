package ca.jbrains.pos.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SellOneItemTest {
    @Test
    void productFound() {
        final Display display = new Display();
        final Sale sale = new Sale(new Catalog(Map.of("12345", "$7.95", "23456", "$12.50")), display);

        sale.onBarcode("12345");

        Assertions.assertEquals("$7.95", display.getText());
    }

    @Test
    void anotherProductFound() {
        final Display display = new Display();
        final Sale sale = new Sale(new Catalog(Map.of("12345", "$7.95", "23456", "$12.50")), display);

        sale.onBarcode("23456");

        Assertions.assertEquals("$12.50", display.getText());
    }

    @Test
    void productNotFound() {
        final Display display = new Display();
        final Sale sale = new Sale(new Catalog(Map.of()), display);

        sale.onBarcode("99999");

        Assertions.assertEquals("Product not found: 99999", display.getText());
    }

    @Test
    void empty() {
        final Display display = new Display();
        final Sale sale = new Sale(new Catalog(Map.of()), display);

        sale.onBarcode("");

        Assertions.assertEquals("Scanning error: empty barcode", display.getText());
    }

    public static class Sale {
        private final Catalog catalog;
        private final Display display;

        public Sale(Catalog catalog, Display display) {
            this.catalog = catalog;
            this.display = display;
        }

        public void onBarcode(String barcode) {
            if ("".equals(barcode))
                display.displayEmptyBarcodeMessage();
            else if (catalog.hasMatchingPriceFor(barcode))
                display.displayPrice(catalog.findPrice(barcode));
            else
                display.displayProductNotFoundMessage(barcode);
        }
    }

    public static class Display {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void displayProductNotFoundMessage(String barcode) {
            setText(String.format("Product not found: %s", barcode));
        }

        private void displayEmptyBarcodeMessage() {
            setText("Scanning error: empty barcode");
        }

        private void displayPrice(String price) {
            setText(price);
        }
    }
}
