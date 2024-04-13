package com.tensketch.resort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resorts")
public class ResortController {

    @Autowired
    private ResortService resortService;

    @GetMapping
    public List<Resort> getAllResorts() {
        return resortService.getAllResorts();
    }

    @GetMapping("/{id}")
    public Optional<Resort> getResortById(@PathVariable Long id) {
        return resortService.getResortById(id);
    }

    @PostMapping
    public Resort addResort(@RequestBody Resort resort) {
        return resortService.saveResort(resort);
        
    }

    @PostMapping("/{resortId}/image")
    public String uploadImage(@PathVariable Long resortId, @RequestParam("imageFile") MultipartFile imageFile) {
        return resortService.uploadImage(resortId, imageFile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateResort(@PathVariable Long id, @RequestBody Resort updatedResort) {
        resortService.updateResort(id, updatedResort);
        return ResponseEntity.status(HttpStatus.OK).body("Resort updated successfully");
    }

    
    @DeleteMapping("/{id}")
    public void deleteResort(@PathVariable Long id) {
        resortService.deleteResort(id);
    }
}
