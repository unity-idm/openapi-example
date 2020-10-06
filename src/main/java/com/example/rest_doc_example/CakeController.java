package com.example.rest_doc_example;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(value = "/v1/cake", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = CakeController.TAG, description = "API with documentation annotations")
public class CakeController
{
	static final String TAG = "cake";
	private final CakeService service;
	
	public CakeController(CakeService service)
	{
		this.service = service;
	}

	@Operation(
			summary = "Get all cakes",
			description = "Retrieve all cakes from the server, this is very slow "
					+ "operation since all cakes are baked synchronously, so all "
					+ "of them are made according to their preparation time."
	)
	@GetMapping
	public Collection<Cake> getAll()
	{
		return service.getAll();
	}

	@Operation(
			summary = "Find cake by name",
			description = "Get recipe of particular cake"
	)
	@GetMapping(value = "/{cake}")
	public Cake getCake(
			@CakeNameParameter @PathVariable("cake") String cakeName)
	{
		return service.getCake(cakeName);
	}
	
	@Operation(
			summary = "Update cake by name",
			description = "Update the recipe of particular cake"
	)
	@PutMapping(value = "/{cake}")
	public void updateCake(
			@CakeBodyParameter @RequestBody Cake cake)
	{
		// update
	}
	
	@Operation(
			summary = "Delete cake by name",
			description = "I don't know why one might want that!"
	)
	@DeleteMapping(value = "/{cake}")
	public void deleteCake(
			@CakeNameParameter @PathVariable("cake") String cakeName)
	{
		// delete
	}
	
	@Operation(
			summary = "Create cake",
			description = "Yummy yummy yummy!"
	)
	@PostMapping()
	public void createCake(
			@CakeBodyParameter @RequestBody Cake cake)
	{
		// create
	}
}
