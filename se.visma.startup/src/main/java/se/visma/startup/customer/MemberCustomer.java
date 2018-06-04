package se.visma.startup.customer;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.Data;
import se.visma.startup.items.StartUpItem;

@Data
public class MemberCustomer extends GeneralCustomer{
	// some kind of classification to say that this member has specific discounts
	List<Class> discountList;
	
	@Override
	public void addItemsToCart(List<StartUpItem> items) {
		Optional.ofNullable(items)
        .orElseGet(Collections::emptyList)
        .stream().filter(Objects::nonNull)
        .forEach(item -> calculateDiscount(item));
	}
	
	private void calculateDiscount(StartUpItem item) {
		if(discountList.contains(item.getClass())) {
			final StartUpItem tempItem = item;
			tempItem.setPrice(item.getPrice().subtract((item.getPrice().multiply(item.getDiscount()))));
			manageItemsInCart.addItemToCart(tempItem);
		} else {
			manageItemsInCart.addItemToCart(item);
		}
	}	
}
