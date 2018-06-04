package se.visma.startup.customer;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.Data;
import se.visma.startup.actions.ItemActions;
import se.visma.startup.cart.ManageItemsInCart;
import se.visma.startup.items.StartUpItem;

@Data
public class GeneralCustomer implements ItemActions{
	private String name;
	private String address;
	protected ManageItemsInCart manageItemsInCart;

	@Override
	public void addItemsToCart(List<StartUpItem> items) {
		Optional.ofNullable(items)
        .orElseGet(Collections::emptyList)
        .stream().filter(Objects::nonNull)
        .forEach(item -> manageItemsInCart.addItemToCart(item));
	}

	@Override
	public List<StartUpItem> getItemsAfterDiscount() {
		return manageItemsInCart.getItemsInCart();
	}
}
