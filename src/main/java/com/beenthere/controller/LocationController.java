package com.beenthere.controller;

import com.beenthere.model.Location;
import com.beenthere.repository.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by James Woo on 3/25/2016.
 */
@RestController
@RequestMapping("api/v1/")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @RequestMapping(value = "locations", method = RequestMethod.GET)
    public List<Location> list() {
        return locationRepository.findAll();
    }

    @RequestMapping(value = "locations", method = RequestMethod.POST)
    public Location create(@RequestBody Location location) {
        return locationRepository.saveAndFlush(location);
    }

    @RequestMapping(value = "locations/{id}", method = RequestMethod.GET)
    public Location get(@PathVariable Long id) {
        return locationRepository.findOne(id);
    }

    @RequestMapping(value = "locations/{id}", method = RequestMethod.PUT)
    public Location get(@PathVariable Long id, @RequestBody Location location) {
        Location existingLocation = locationRepository.findOne(id);
        BeanUtils.copyProperties(location, existingLocation);
        return locationRepository.saveAndFlush(existingLocation);
    }

    @RequestMapping(value = "locations/{id}", method = RequestMethod.DELETE)
    public Location delete(@PathVariable Long id) {
        Location existingLocation = locationRepository.findOne(id);
        locationRepository.delete(existingLocation);
        return existingLocation;
    }
}
