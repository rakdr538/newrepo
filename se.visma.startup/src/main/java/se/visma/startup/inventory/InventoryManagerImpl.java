package se.visma.startup.inventory;

import java.util.ArrayList;
import java.util.List;

import se.visma.startup.items.StartUpItem;

public class InventoryManagerImpl implements InventoryManager{
	
	private List<StartUpItem> inventoryItems = new ArrayList<StartUpItem>();

	@Override
	public void addItemToInventory(StartUpItem newItem) {
		inventoryItems.add(newItem);
	}

	@Override
	public void removeItemFromInventory(StartUpItem oldItem) {
		inventoryItems.remove(oldItem);
	}

	@Override
	public List<StartUpItem> getItemsInInventory() {
		return inventoryItems;
	}

}
