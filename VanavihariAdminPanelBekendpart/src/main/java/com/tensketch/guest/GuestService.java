package com.tensketch.guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public Guest updateGuest(Long id, Guest updatedGuest) {
        updatedGuest.setId(id);
        return guestRepository.save(updatedGuest);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}
