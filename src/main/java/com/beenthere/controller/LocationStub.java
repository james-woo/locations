package com.beenthere.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beenthere.model.Location;

public class LocationStub {
	private static Map<Long, Location> locations = new HashMap<Long, Location>();
	private static Long idIndex = 3L;

	//populate initial locations
	static {
		Location a = new Location(1L, "Germany", "Germany trip", "Germany", "Berlin", "https://upload.wikimedia.org/wikipedia/commons/1/17/High_income_country_economies_by_world_bank_2015.png", 44.12, 138.44, 2015);
		locations.put(1L, a);
		Location b = new Location(1L, "Korea", "Korea trip", "Korea", "Seoul", "https://upload.wikimedia.org/wikipedia/commons/1/17/High_income_country_economies_by_world_bank_2015.png", 44.12, 138.44, 2015);
		locations.put(2L, b);
		Location c = new Location(1L, "Mexico", "Mexico trip", "Mexico", "Cancun", "https://upload.wikimedia.org/wikipedia/commons/1/17/High_income_country_economies_by_world_bank_2015.png", 44.12, 138.44, 2015);
		locations.put(3L, c);
	}

	public static List<Location> list() {
		return new ArrayList<Location>(locations.values());
	}

	public static Location create(Location location) {
		idIndex += idIndex;
		location.setId(idIndex);
		locations.put(idIndex, location);
		return location;
	}

	public static Location get(Long id) {
		return locations.get(id);
	}

	public static Location update(Long id, Location location) {
		locations.put(id, location);
		return location;
	}

	public static Location delete(Long id) {
		return locations.remove(id);
	}
}
