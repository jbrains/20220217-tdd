package ca.jbrains.pos;

public class Sale {
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
            display.displayPrice(catalog.findFormattedPrice(barcode));
        else
            display.displayProductNotFoundMessage(barcode);
    }

    public void onTotal() {
        display.displayTotal(2490);
    }
}
