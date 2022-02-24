package ca.jbrains.pos;

public class Purchase {
    int totalCostOfItemsPurchased = 0;

    void addItemToCurrentPurchase(int price) {
        totalCostOfItemsPurchased += price;
    }

    void startNewPurchase() {
        totalCostOfItemsPurchased = 0;
    }
}