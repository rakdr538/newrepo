package se.visma.startup.items;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemImpl implements StartUpItem{
	private BigDecimal price;
	private String description;
	private BigDecimal discount;
}
