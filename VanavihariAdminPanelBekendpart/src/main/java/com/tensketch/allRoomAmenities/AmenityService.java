package com.tensketch.allRoomAmenities;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AmenityService {
    @Autowired
    private AmenityRepository amenityRepository;


    public AmenityService(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();
    }
    public Amenity getAmenityById(Long id) {
        return amenityRepository.findById(id)
                .orElseThrow();
    }

    public Amenity createAmenity(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    public Amenity updateAmenity(Long id, Amenity updatedAmenity) {
        Amenity existingAmenity = amenityRepository.findById(id)
                .orElseThrow();

        existingAmenity.setName(updatedAmenity.getName());

        return amenityRepository.save(existingAmenity);
    }

    public void deleteAmenity(Long id) {
        Amenity amenity = amenityRepository.findById(id)
                .orElseThrow();

        amenityRepository.delete(amenity);
    }
}
