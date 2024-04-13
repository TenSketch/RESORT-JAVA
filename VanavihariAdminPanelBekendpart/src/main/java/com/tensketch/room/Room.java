package com.tensketch.room;




import com.tensketch.cottageType.CottageType;
//import com.tensketch.resort.Resort;
import com.tensketch.resort1.Resort1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Resort1 resort1;
    
    @ManyToOne
    private CottageType cottageType;
    
//    private String roomId;
    private String roomName;
    private String roomImage;
    private double weekdaysRate;
    private double weekendsRate;
    private int maxAllowedAdult;
    private int maxAllowedChild;
    private double chargesPerBedWeekdays;
    private double chargesPerBedWeekends;

    // Constructors, getters, and setters
}
