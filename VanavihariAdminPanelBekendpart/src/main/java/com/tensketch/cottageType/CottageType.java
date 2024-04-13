package com.tensketch.cottageType;
import java.util.List;


import com.tensketch.allRoomAmenities.Amenity;
//import com.tensketch.resort.Resort;
import com.tensketch.resort1.Resort1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class CottageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cottageName;
    private String description;

    // Resort can have multiple cottages of this type
    @ManyToOne
    private Resort1 resort1;

    // A cottage type can have multiple amenities
    @ManyToMany
    private List<Amenity> amenities;

    // getters and setters
  
}

