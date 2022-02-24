package ca.jbrains.pos;

public class Sale {
    private final Catalog catalog;
    private final Display display;
    private int totalCostOfItemsPurchased = 0;

    public Sale(Catalog catalog, Display display) {
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode))
            display.displayEmptyBarcodeMessage();
        else if (catalog.hasMatchingPriceFor(barcode)) {
            final int price = catalog.findPrice(barcode);
            addItemToCurrentPurchase(price);
            display.displayPrice(price);
        } else
            display.displayProductNotFoundMessage(barcode);
    }

    private void addItemToCurrentPurchase(int price) {
        totalCostOfItemsPurchased += price;
    }

    public void onTotal() {
        display.displayTotal(totalCostOfItemsPurchased);
        startNewPurchase();
    }

    private void startNewPurchase() {
        totalCostOfItemsPurchased = 0;
    }
}
