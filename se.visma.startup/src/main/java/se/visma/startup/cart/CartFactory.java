package se.visma.startup.cart;

public class CartFactory {

	private CartFactory() {
	}

	public static ManageItemsInCart manageItemsInCart() {
			return new ManageItemsInCartImpl();
	}
}
