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
		//Long id, String name, String description, String country, String city, Double latitude, Double longitude, Integer year
		Location a = new Location(1L, "Germany", "Germany trip", "Germany", "Berlin", 44.12, 138.44, 2015);
		locations.put(1L, a);
		Location b = new Location(1L, "Korea", "Korea trip", "Korea", "Seoul", 44.12, 138.44, 2015);
		locations.put(2L, b);
		Location c = new Location(1L, "Mexico", "Mexico trip", "Mexico", "Cancun", 44.12, 138.44, 2015);
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
