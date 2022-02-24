package ca.jbrains.pos;

import java.util.Map;

public final class Catalog {
    private final Map<String, Integer> pricesInCentsByBarcode;

    public Catalog(Map<String, Integer> pricesInCentsByBarcode) {
        this.pricesInCentsByBarcode = pricesInCentsByBarcode;
    }

    public int findPrice(String barcode) {
        return pricesInCentsByBarcode.get(barcode);
    }

    public boolean hasMatchingPriceFor(String barcode) {
        return pricesInCentsByBarcode.containsKey(barcode);
    }
}