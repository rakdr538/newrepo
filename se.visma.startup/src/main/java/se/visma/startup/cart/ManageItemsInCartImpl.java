package se.visma.startup.cart;

import java.util.ArrayList;
import java.util.List;

import se.visma.startup.inventory.StartUpInventoryManagerFactory;
import se.visma.startup.items.StartUpItem;

public class ManageItemsInCartImpl implements ManageItemsInCart{
	
	private List<StartUpItem> items = new ArrayList<StartUpItem>();

	@Override
	public void addItemToCart(StartUpItem item) {
		if(StartUpInventoryManagerFactory.getInventoryManager().getItemsInInventory().contains(item)) {
			items.add(item);
		}
	}

	@Override
	public void deleteItemFromCart(StartUpItem item) {
		if(items.contains(item)) {
			items.remove(item);
		}
	}

	@Override
	public List<StartUpItem> getItemsInCart() {
		return items;
	}

}
