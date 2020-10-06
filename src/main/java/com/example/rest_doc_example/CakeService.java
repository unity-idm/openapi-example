package com.example.rest_doc_example;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;

@Component
class CakeService
{
	private static final Map<String, Cake> CAKE_BY_NAME = ImmutableMap.of(
			Cake.CHEESE_CAKE.getName(), Cake.CHEESE_CAKE,
			Cake.CHOCOLATE_CAKE.getName(), Cake.CHOCOLATE_CAKE
	);
	
	Collection<Cake> getAll()
	{
		return CAKE_BY_NAME.values();
	}

	Cake getCake(String cakeName)
	{
		if (CAKE_BY_NAME.containsKey(cakeName))
			return CAKE_BY_NAME.get(cakeName);
		throw new CakeNotFoundException("unknown cake: " + cakeName);
	}
}
