package se.visma.startup.items;

import java.math.BigDecimal;

public interface StartUpItem {

	void setPrice(BigDecimal float1);
	
	void setDescription(String description1);
	
	BigDecimal getPrice();
	
	String getDescription();

	public BigDecimal getDiscount();
	
	public void setDiscount(BigDecimal discount);
}
