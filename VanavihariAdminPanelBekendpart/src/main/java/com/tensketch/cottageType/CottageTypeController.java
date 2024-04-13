package com.tensketch.cottageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cottagetypes")
public class CottageTypeController {
    @Autowired
    private CottageTypeService cottageTypeService;

    @GetMapping
    public List<CottageType> getAllCottageTypes() {
        return cottageTypeService.getAllCottageTypes();
    }

    @GetMapping("/{id}")
    public Optional<CottageType> getCottageTypeById(@PathVariable Long id) {
        return cottageTypeService.getCottageTypeById(id);
    }

    @PostMapping
    public CottageType createCottageType(@RequestBody CottageType cottageType) {
        return cottageTypeService.createCottageType(cottageType);
    }

    @PutMapping("/{id}")
    public CottageType updateCottageType(@PathVariable Long id, @RequestBody CottageType cottageType) {
        return cottageTypeService.updateCottageType(id, cottageType);
    }

    @DeleteMapping("/{id}")
    public void deleteCottageType(@PathVariable Long id) {
        cottageTypeService.deleteCottageType(id);
    }
}

