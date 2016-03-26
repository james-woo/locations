package com.beenthere.repository;

import com.beenthere.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by James Woo on 3/25/2016.
 */
public interface LocationRepository extends JpaRepository<Location, Long> {

}
