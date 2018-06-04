package se.visma.startup.customer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import se.visma.startup.cart.CartFactory;
import se.visma.startup.inventory.StartUpInventoryManagerFactory;
import se.visma.startup.items.FurnitureItem;
import se.visma.startup.items.HotdogItem;
import se.visma.startup.items.StartUpItem;
import se.visma.startup.items.TextileItem;

public class StartUpCustomerTest {

	@Test
	public void testCustomerWith2ItemsWithNoDiscount() {
		GeneralCustomer customer1 = new GeneralCustomer();
		customer1.setManageItemsInCart(CartFactory.manageItemsInCart());
		TextileItem carpet = Mockito.mock(TextileItem.class);
		HotdogItem chiliHotdog = Mockito.mock(HotdogItem.class);
		StartUpInventoryManagerFactory.getInventoryManager().addItemToInventory(carpet);
		StartUpInventoryManagerFactory.getInventoryManager().addItemToInventory(chiliHotdog);
		List<StartUpItem> items = new ArrayList<StartUpItem>();
		items.add(carpet);
		items.add(chiliHotdog);
		customer1.addItemsToCart(items);
		assertEquals(2, customer1.getItemsAfterDiscount().size());
	}

	@Test
	public void testCustomerWith3ItemsAndDiscount() {
		MemberCustomer customer1 = new MemberCustomer();
		customer1.setManageItemsInCart(CartFactory.manageItemsInCart());
		FurnitureItem wardrobe = Mockito.mock(FurnitureItem.class);
		TextileItem rug = Mockito.mock(TextileItem.class);
		HotdogItem veggiHotdog = Mockito.mock(HotdogItem.class);
		StartUpInventoryManagerFactory.getInventoryManager().addItemToInventory(wardrobe);
		StartUpInventoryManagerFactory.getInventoryManager().addItemToInventory(rug);
		StartUpInventoryManagerFactory.getInventoryManager().addItemToInventory(veggiHotdog);
		List<StartUpItem> items = new ArrayList<StartUpItem>();
		items.add(wardrobe);
		items.add(rug);
		items.add(veggiHotdog);
		@SuppressWarnings("rawtypes")
		List<Class> discountList = new ArrayList<Class>();
		discountList.add(FurnitureItem.class);
		discountList.add(HotdogItem.class);
		customer1.setDiscountList(discountList );
		customer1.addItemsToCart(items);
		assertEquals(3, customer1.getItemsAfterDiscount().size());
	}
}
