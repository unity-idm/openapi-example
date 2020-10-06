package com.example.rest_doc_example;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Ingredient
{
	static final Ingredient FLOUR = new Ingredient("Mąka", 0.5, "kg");
	static final Ingredient CHOCOLATE = new Ingredient("Czekolada", 100, "g");
	static final Ingredient CHEESE = new Ingredient("Ser", 0.4, "kg");
	static final Ingredient RAISINS = new Ingredient("Rodzynki", 50, "dg");

	@NotBlank
    @Size(min = 0, max = 20)
	private final String name;
	@NotBlank
	private final double quantity;
	@NotBlank
	private final String unit;

	@JsonCreator
	Ingredient(@JsonProperty("name") String name,
			@JsonProperty("quantity") double quantity,
			@JsonProperty("unit") String unit)
	{
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
	}

	public String getName()
	{
		return name;
	}

	public double getQuantity()
	{
		return quantity;
	}

	public String getUnit()
	{
		return unit;
	}
}
