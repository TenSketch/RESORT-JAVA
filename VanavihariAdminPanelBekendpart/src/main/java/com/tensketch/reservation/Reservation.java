package com.tensketch.reservation;

import java.time.LocalDateTime;


import com.tensketch.cottageType.CottageType;
import com.tensketch.guest.Guest;
//import com.tensketch.resort.Resort;
import com.tensketch.resort1.Resort1;
import com.tensketch.room.Room;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private int numberOfAdults;
    private int numberOfGuest;
    private int numberOfRooms;

    private int numberOfChildren;

    @ManyToOne
    private Guest guest;

    @ManyToOne
    private Room room;
    

    @ManyToOne
    private CottageType cottageType;
    
    @ManyToOne
    private Resort1 resort1;

    // Getters and setters
}