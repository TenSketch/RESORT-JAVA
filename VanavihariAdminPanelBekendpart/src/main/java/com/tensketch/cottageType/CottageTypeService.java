package com.tensketch.cottageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CottageTypeService {
    @Autowired
    private CottageTypeRepository cottageTypeRepository;

    public List<CottageType> getAllCottageTypes() {
        return cottageTypeRepository.findAll();
    }

    public Optional<CottageType> getCottageTypeById(Long id) {
        return cottageTypeRepository.findById(id);
    }

    public CottageType createCottageType(CottageType cottageType) {
        return cottageTypeRepository.save(cottageType);
    }

    public CottageType updateCottageType(Long id, CottageType updatedCottageType) {
        if (cottageTypeRepository.existsById(id)) {
            updatedCottageType.setId(id); // Ensure the ID is set for update
            return cottageTypeRepository.save(updatedCottageType);
        } else {
            throw new RuntimeException("Cottage type not found with id: " + id);
        }
    }

    public void deleteCottageType(Long id) {
        cottageTypeRepository.deleteById(id);
    }
}


