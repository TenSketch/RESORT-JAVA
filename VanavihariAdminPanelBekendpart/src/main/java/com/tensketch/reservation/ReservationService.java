package com.tensketch.reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                                    .orElseThrow(() -> new NoSuchElementException("Reservation not found"));
    }

    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = getReservationById(id);

        existingReservation.setCheckIn(updatedReservation.getCheckIn());
        existingReservation.setCheckOut(updatedReservation.getCheckOut());
        existingReservation.setNumberOfAdults(updatedReservation.getNumberOfAdults());
        existingReservation.setNumberOfChildren(updatedReservation.getNumberOfChildren());
        existingReservation.setGuest(updatedReservation.getGuest());
        existingReservation.setRoom(updatedReservation.getRoom());
        existingReservation.setCottageType(updatedReservation.getCottageType());
        existingReservation.setResort1(updatedReservation.getResort1());

        return reservationRepository.save(existingReservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
