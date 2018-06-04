package se.visma.startup.controller;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.http.HttpStatus;
import org.json.JSONObject;

import se.visma.startup.inventory.StartUpInventoryManagerFactory;
import se.visma.startup.items.FurnitureItem;
import se.visma.startup.items.StartUpItem;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This class will add new items to StartUp
 */
public class InventoryController {
	// this is model code without realistic logic
	public static Route addToInventory = (Request request, Response response) -> {
		JSONObject jsonObj = new JSONObject(request.body());
		mapItemsInCategories(jsonObj)
				.forEach(item -> StartUpInventoryManagerFactory.getInventoryManager().addItemToInventory(item));
		response.status(HttpStatus.OK_200);
		return response;
	};

	private static List<StartUpItem> mapItemsInCategories(JSONObject jsonObj) {
		// Map items using some pre-defined interface
		List<StartUpItem> items = new ArrayList<StartUpItem>();
		// example logic as follows
		jsonObj.getJSONArray("furniture").forEach((furnitureItem) -> {
			FurnitureItem newFurnitureItem = new FurnitureItem();
			newFurnitureItem.setDescription(((JSONObject) furnitureItem).getString("description"));
			newFurnitureItem.setDiscount(((JSONObject) furnitureItem).getBigDecimal("discount"));
			newFurnitureItem.setItemNummer(((JSONObject) furnitureItem).getInt("itemNummer"));
			newFurnitureItem.setPrice(((JSONObject) furnitureItem).getBigDecimal("price"));
			newFurnitureItem.setWeight(((JSONObject) furnitureItem).getBigDecimal("weight"));
		});
		return items;
	}
}
