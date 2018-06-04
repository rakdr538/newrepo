package se.visma.startup.cart;

import java.util.List;

import se.visma.startup.items.StartUpItem;

public interface ManageItemsInCart {
	void addItemToCart(StartUpItem item);
	void deleteItemFromCart(StartUpItem item);
	List<StartUpItem> getItemsInCart();
}
