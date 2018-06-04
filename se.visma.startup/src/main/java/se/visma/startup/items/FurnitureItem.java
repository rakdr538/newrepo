package se.visma.startup.items;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FurnitureItem extends ItemImpl {
	private BigDecimal weight;
	private Integer itemNummer;
}
