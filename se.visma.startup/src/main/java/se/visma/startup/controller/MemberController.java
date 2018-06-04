package se.visma.startup.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.jetty.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;

import se.visma.startup.customer.MemberCustomer;
import se.visma.startup.customer.MemberDataBase;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This class will add new member to StartUp
 */
public class MemberController {
	// this is model code without realistic logic
	public static Route addMemberToStartUp = (Request request, Response response) -> {
		JSONObject jsonObj = new JSONObject(request.body());
		MemberCustomer newMemberCustomer = new MemberCustomer();
		newMemberCustomer.setName(jsonObj.getString("name"));
		newMemberCustomer.setAddress(jsonObj.getString("address"));
		JSONArray discountListArray = jsonObj.getJSONArray("discountList");
		List<Class> discountList = new ArrayList<Class>();
		Optional.ofNullable(discountListArray).ifPresent(memberDiscount -> discountList.add(memberDiscount.getClass()));
		newMemberCustomer.setDiscountList(discountList);
		MemberDataBase.addMemberToStartUp(newMemberCustomer);
		response.body(new JSONObject(newMemberCustomer).toString());
		response.status(HttpStatus.OK_200);
		return response;
	};
}
