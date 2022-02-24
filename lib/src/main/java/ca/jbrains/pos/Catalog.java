package ca.jbrains.pos;

import java.util.Map;

public final class Catalog {
    private final Map<String, Integer> pricesInCentsByBarcode;

    public Catalog(Map<String, String> pricesByBarcode, Map<String, Integer> pricesInCentsByBarcode) {
        this.pricesInCentsByBarcode = pricesInCentsByBarcode;
    }

    public String findPrice(String barcode) {
        return Display.formatAmount(pricesInCentsByBarcode.get(barcode));
    }

    public boolean hasMatchingPriceFor(String barcode) {
        return pricesInCentsByBarcode.containsKey(barcode);
    }
}