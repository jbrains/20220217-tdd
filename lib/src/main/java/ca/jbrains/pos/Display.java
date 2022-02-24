package ca.jbrains.pos;

public class Display {
    private String text;

    public String getText() {
        return text;
    }

    public void displayProductNotFoundMessage(String barcode) {
        this.text = String.format("Product not found: %s", barcode);
    }

    public void displayEmptyBarcodeMessage() {
        this.text = "Scanning error: empty barcode";
    }

    public void displayFormattedPrice(String price) {
        this.text = price;
    }

    public void displayTotal(int totalInCents) {
        this.text = String.format("Total: %s", formatAmount(totalInCents));
    }

    public static String formatAmount(int totalInCents) {
        return String.format("$%.2f", amountInDollars(totalInCents));
    }

    private static double amountInDollars(int totalInCents) {
        return totalInCents / 100.0d;
    }
}
