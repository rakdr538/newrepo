/**
 * 
 */
package se.visma.startup;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import se.visma.startup.controller.CustomerController;
import se.visma.startup.controller.InventoryController;
import se.visma.startup.controller.MemberController;

/**
 * @author rakesh
 *
 */
public class StartUpApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Configure Spark
        port(4567);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        
		get("/", (request, response) -> "Welcome to simple web app!!");
		post("/addItemsToInventory", InventoryController.addToInventory);
		post("/addMemberToStartUp", MemberController.addMemberToStartUp);
		get("/customer_id", CustomerController.giveAnyCustomerCart);
		post("/customer_id_addItemsToCart", CustomerController.addItemsToCart);
		post("/customer_id_getItemsInCart", CustomerController.getItemsInCart);
	}

}
