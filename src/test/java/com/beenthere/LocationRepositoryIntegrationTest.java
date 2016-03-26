package com.beenthere;

import com.beenthere.model.Location;
import com.beenthere.repository.LocationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(BeenthereApplication.class)
public class LocationRepositoryIntegrationTest {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void testFindAll() {
        List<Location> locations = locationRepository.findAll();
        assertThat(locations.size(), is(greaterThanOrEqualTo(0)));
    }
}
