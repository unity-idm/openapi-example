package com.example.rest_doc_example;

import static com.example.rest_doc_example.Ingredient.CHEESE;
import static com.example.rest_doc_example.Ingredient.CHOCOLATE;
import static com.example.rest_doc_example.Ingredient.FLOUR;
import static com.example.rest_doc_example.Ingredient.RAISINS;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * NOTE: in order for class properties be pulled into the doc,
 * getter must be public.
 */
class Cake
{
	static final Cake CHEESE_CAKE = new Cake("Sernik", 60, ImmutableList.of(FLOUR, CHEESE, RAISINS));
	static final Cake CHOCOLATE_CAKE = new Cake("Czekoladowy", 60, ImmutableList.of(FLOUR, CHOCOLATE));

	/**
	 * When model includes JSR-303 bean validation annotations, the
	 * springdoc-openapi library uses them to generate additional schema
	 * documentation for the corresponding constraints.
	 */
	@NotBlank
	@Size(min = 0, max = 20)
	@Schema(description = "Name of the cake.", example = "cheese cake", required = true)
	private final String name;
	@Min(0)
	@Max(120)
	@Schema(description = "Preparation time in minues.", example = "60", required = false)
	private final Integer prepTimeMin;
	@NotBlank
	@Schema(description = "List if ingredients.", required = true)
	private final List<Ingredient> components;

	@JsonCreator
	Cake(@JsonProperty("name") String name,
			@JsonProperty("prepTimeMin") int prepTimeMin,
			@JsonProperty("components") List<Ingredient> components)
	{
		this.name = name;
		this.prepTimeMin = prepTimeMin;
		this.components = ImmutableList.copyOf(components);
	}

	public String getName()
	{
		return name;
	}

	public int getPrepTimeMin()
	{
		return prepTimeMin;
	}

	public List<Ingredient> getComponents()
	{
		return components;
	}
}
