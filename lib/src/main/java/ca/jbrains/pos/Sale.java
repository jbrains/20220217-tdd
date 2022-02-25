package ca.jbrains.pos;

public class Sale {
    private final Catalog catalog;
    private final Display display;
    private Purchase purchase = new Purchase();

    public Sale(Catalog catalog, Display display) {
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode))
            display.displayEmptyBarcodeMessage();
        else if (catalog.hasMatchingPriceFor(barcode)) {
            final int price = catalog.findPrice(barcode);
            purchase.addItemToCurrentPurchase(price);
            display.displayPrice(price);
        } else
            display.displayProductNotFoundMessage(barcode);
    }

    public void onTotal() {
        display.displayTotal(purchase.totalCostOfItemsPurchased);
        purchase = new Purchase();
    }
}
