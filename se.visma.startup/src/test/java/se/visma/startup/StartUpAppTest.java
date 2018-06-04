package se.visma.startup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import se.visma.startup.cart.CartFactory;
import se.visma.startup.customer.GeneralCustomer;
import se.visma.startup.customer.MemberCustomer;
import se.visma.startup.inventory.StartUpInventoryManagerFactory;
import se.visma.startup.items.FurnitureItem;
import se.visma.startup.items.HotdogItem;
import se.visma.startup.items.StartUpItem;
import se.visma.startup.items.TextileItem;

public class StartUpAppTest {

	@Test
	public void test() {
		FurnitureItem wardrobe = new FurnitureItem();
		wardrobe.setPrice(new BigDecimal(900));
		wardrobe.setItemNummer(12345);
		wardrobe.setDescription("This is wardrobe");
		wardrobe.setWeight(new BigDecimal(10.345));
		wardrobe.setDiscount(new BigDecimal(0.1));

		HotdogItem chiliHotdog = new HotdogItem();
		chiliHotdog.setDescription("I am chili");
		chiliHotdog.setDiscount(new BigDecimal(0.01));
		chiliHotdog.setPrice(new BigDecimal(30));
		chiliHotdog.setFlavor("chili");

		HotdogItem veggiHotdog = new HotdogItem();
		veggiHotdog.setDescription("I am Vegetarian");
		veggiHotdog.setDiscount(new BigDecimal(0));
		veggiHotdog.setPrice(new BigDecimal(30));
		veggiHotdog.setFlavor("veggi");

		TextileItem rug = new TextileItem();
		rug.setDescription("Rug is my name");
		rug.setDiscount(new BigDecimal(0.02));
		rug.setPrice(new BigDecimal(50.90));
		rug.setColor(new Color(30000));
		rug.setItemNummer(12345);

		TextileItem carpet = new TextileItem();
		carpet.setDescription("Carpet is my name");
		carpet.setDiscount(new BigDecimal(0.05));
		carpet.setPrice(new BigDecimal(56.90));
		carpet.setColor(new Color(70000));
		carpet.setItemNummer(12345);

		StartUpInventoryManagerFactory.getInventoryManager().addItemToInventory(wardrobe);
		StartUpInventoryManagerFactory.getInventoryManager().addItemToInventory(chiliHotdog);
		StartUpInventoryManagerFactory.getInventoryManager().addItemToInventory(veggiHotdog);
		StartUpInventoryManagerFactory.getInventoryManager().addItemToInventory(rug);
		StartUpInventoryManagerFactory.getInventoryManager().addItemToInventory(carpet);

		List<StartUpItem> buyList1 = new ArrayList<StartUpItem>();
		buyList1.add(carpet);
		buyList1.add(veggiHotdog);

		GeneralCustomer generalCustomer = new GeneralCustomer();
		generalCustomer.setManageItemsInCart(CartFactory.manageItemsInCart());
		generalCustomer.setName("Joe");
		generalCustomer.setAddress("Lives in Hamburg");
		generalCustomer.addItemsToCart(buyList1);
		assertEquals(2, generalCustomer.getItemsAfterDiscount().size());

		List<StartUpItem> buyList2 = new ArrayList<StartUpItem>();
		buyList2.add(wardrobe);
		buyList2.add(rug);
		buyList2.add(veggiHotdog);

		List<Class> discountClasses = new ArrayList<Class>();
		discountClasses.add(FurnitureItem.class);
		discountClasses.add(HotdogItem.class);

		MemberCustomer memberCustomer = new MemberCustomer();
		memberCustomer.setManageItemsInCart(CartFactory.manageItemsInCart());
		memberCustomer.setName("Roger");
		memberCustomer.setAddress("Lives in Ireland");
		memberCustomer.setDiscountList(discountClasses);
		memberCustomer.addItemsToCart(buyList2);
		for (int i = 0; i < buyList2.size(); i++) {
			assertTrue(buyList2.get(i).getDescription()
					.equals(memberCustomer.getItemsAfterDiscount().get(i).getDescription()));
			assertTrue(buyList2.get(i).getPrice().intValue()>=memberCustomer.getItemsAfterDiscount().get(i).getPrice().intValue());
		}

	}

}
