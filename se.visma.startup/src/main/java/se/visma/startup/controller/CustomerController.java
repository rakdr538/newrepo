package se.visma.startup.controller;

import org.eclipse.jetty.http.HttpStatus;
import org.json.JSONObject;

import se.visma.startup.cart.CartFactory;
import se.visma.startup.customer.GeneralCustomer;
import se.visma.startup.customer.MemberDataBase;
import se.visma.startup.items.StartUpItem;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This class is used to manage Customer behavior
 */
public class CustomerController {

	static GeneralCustomer customer;

	// this is model code without realistic logic
	public static Route giveAnyCustomerCart = (Request request, Response response) -> {
		customer = new GeneralCustomer();
		customer.setManageItemsInCart(CartFactory.manageItemsInCart());
		// in response we can send cart for this customer along with certain handle
		// connected to session or login.
		response.body(new JSONObject(customer).toString());
		response.status(HttpStatus.OK_200);
		return response;
	};

	// this is model code without realistic logic
	public static Route addItemsToCart = (Request request, Response response) -> {
		JSONObject jsonObj = new JSONObject(request.body());
		JSONObject resObj = new JSONObject();
		customer = MemberDataBase.getCustomer(jsonObj.getJSONObject("ThisCustomer").get("customer_id"));
		if (!isAnonymousCustomer()) {
			resObj.put("name", customer.getName());
			resObj.put("address", customer.getAddress());
		}
		jsonObj.getJSONArray("items")
				.forEach(item -> customer.getManageItemsInCart().addItemToCart((StartUpItem) item));
		// in response all items in cart are sent
		resObj.put("items", customer.getManageItemsInCart().getItemsInCart());
		response.body(resObj.toString());
		response.status(HttpStatus.OK_200);
		return response;
	};

	// this is model code without realistic logic
	public static Route getItemsInCart = (Request request, Response response) -> {
		JSONObject jsonObj = new JSONObject(request.body());
		customer = MemberDataBase.getCustomer(jsonObj.getJSONObject("ThisCustomer").get("customer_id"));
		JSONObject resObj = new JSONObject();
		resObj.put("items", customer.getManageItemsInCart().getItemsInCart());
		response.body(resObj.toString());
		response.status(HttpStatus.OK_200);
		return response;
	};

	private static boolean isAnonymousCustomer() {
		// TODO Auto-generated method stub
		return false;
	}
}
