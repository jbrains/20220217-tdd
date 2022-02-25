package ca.jbrains.pos;

public class Sale {
    private final Catalog catalog;
    private final Display display;
    private Purchase currentPurchase = new Purchase();

    public Sale(Catalog catalog, Display display) {
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode))
            display.displayEmptyBarcodeMessage();
        else if (catalog.hasMatchingPriceFor(barcode)) {
            final int price = catalog.findPrice(barcode);
            currentPurchase.addItemToCurrentPurchase(price);
            display.displayPrice(price);
        } else
            display.displayProductNotFoundMessage(barcode);
    }

    public void onTotal() {
        display.displayTotal(currentPurchase.totalCostOfItemsPurchased);
        currentPurchase = new Purchase();
    }
}
