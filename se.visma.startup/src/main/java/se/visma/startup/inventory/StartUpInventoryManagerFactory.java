package se.visma.startup.inventory;

public class StartUpInventoryManagerFactory {
	private static InventoryManager inventoryManager;

	private StartUpInventoryManagerFactory() {
	}

	public static InventoryManager getInventoryManager() {
		if (inventoryManager == null) {
			return inventoryManager = new InventoryManagerImpl();
		}
		return inventoryManager;
	}
}
