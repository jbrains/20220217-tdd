package ca.jbrains.pos;

import java.util.Map;

public final class Catalog {
    private final Map<String, String> pricesByBarcode;

    public Catalog(Map<String, String> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode;
    }

    public String findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }

    public boolean hasMatchingPriceFor(String barcode) {
        return pricesByBarcode.containsKey(barcode);
    }
}