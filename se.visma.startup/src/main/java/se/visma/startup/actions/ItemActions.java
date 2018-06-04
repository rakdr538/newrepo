package se.visma.startup.actions;

import java.util.List;

import se.visma.startup.items.StartUpItem;

public interface ItemActions {
	void addItemsToCart(List<StartUpItem> items);
	public List<StartUpItem> getItemsAfterDiscount();
}
