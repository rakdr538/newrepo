package se.visma.startup.inventory;

import java.util.List;

import se.visma.startup.items.StartUpItem;

public interface InventoryManager {
	
	public void addItemToInventory(StartUpItem newItem);
	
	public void removeItemFromInventory(StartUpItem oldItem);
	
	public List<StartUpItem> getItemsInInventory();

}
