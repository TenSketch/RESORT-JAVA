package com.tensketch.allRoomAmenities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amenities")
public class AmenityController {

	@Autowired
    private  AmenityService amenityService;

    public AmenityController(AmenityService amenityService) {
        this.amenityService = amenityService;
    }

    @GetMapping
    public List<Amenity> getAllAmenities() {
        return amenityService.getAllAmenities();
    }

    @GetMapping("/{id}")
    public Amenity getAmenityById(@PathVariable Long id) {
        return amenityService.getAmenityById(id);
    }

    @PostMapping
    public Amenity createAmenity(@RequestBody Amenity amenity) {
        return amenityService.createAmenity(amenity);
    }

    @PutMapping("/{id}")
    public Amenity updateAmenity(@PathVariable Long id, @RequestBody Amenity amenity) {
        return amenityService.updateAmenity(id, amenity);
    }

    @DeleteMapping("/{id}")
    public void deleteAmenity(@PathVariable Long id) {
        amenityService.deleteAmenity(id);
    }
}
