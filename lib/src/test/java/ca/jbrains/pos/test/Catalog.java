package ca.jbrains.pos.test;

import java.util.Map;

public final class Catalog {
    private final Map<String, String> pricesByBarcode;

    public Catalog(Map<String, String> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode;
    }

    String findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }

    boolean hasMatchingPriceFor(String barcode) {
        return pricesByBarcode.containsKey(barcode);
    }
}