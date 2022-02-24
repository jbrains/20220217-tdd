package ca.jbrains.pos;

import java.util.Map;

public final class Catalog {
    private final Map<String, String> pricesByBarcode;
    private final Map<String, Integer> pricesInCentsByBarcode;

    @Deprecated
    public Catalog(Map<String, String> pricesByBarcode) {
        this(pricesByBarcode, null);
    }

    public Catalog(Map<String, String> pricesByBarcode, Map<String, Integer> pricesInCentsByBarcode) {
        this.pricesByBarcode = pricesByBarcode;
        this.pricesInCentsByBarcode = pricesInCentsByBarcode;
    }

    public String findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }

    public boolean hasMatchingPriceFor(String barcode) {
        if (pricesInCentsByBarcode == null)
            return pricesByBarcode.containsKey(barcode);
        else
            return pricesInCentsByBarcode.containsKey(barcode);
    }
}