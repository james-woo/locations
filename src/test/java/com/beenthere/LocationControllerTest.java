package com.beenthere;

import com.beenthere.controller.LocationController;
import com.beenthere.model.Location;
import com.beenthere.repository.LocationRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LocationControllerTest {
    @InjectMocks
    private LocationController lc;

    @Mock
    private LocationRepository locationRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLocationGet() {
        Location ln = new Location();
        ln.setId(1l);
        when(locationRepository.findOne(1l)).thenReturn(ln);

        Location location = lc.get(1l);

        verify(locationRepository).findOne(1l);

        //assertEquals(1l, location.getId().longValue());
        assertThat(location.getId(), is(1l));
    }
}
