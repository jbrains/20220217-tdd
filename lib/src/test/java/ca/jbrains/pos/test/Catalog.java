package ca.jbrains.pos.test;

import java.util.Map;

public record Catalog(Map<String, String> pricesByBarcode) {
    String findPrice(String barcode) {
        return pricesByBarcode().get(barcode);
    }

    boolean hasMatchingPriceFor(String barcode) {
        return pricesByBarcode().containsKey(barcode);
    }
}