package com.tensketch.resort;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResortService {

    @Autowired
    private ResortRepository resortRepository;

    public List<Resort> getAllResorts() {
        return resortRepository.findAll();
    }

    public Optional<Resort> getResortById(Long id) {
        return resortRepository.findById(id);
    }

    public Resort saveResort(Resort resort) {
        return resortRepository.save(resort);
        
        
    }
    
    public String uploadImage(Long resortId, MultipartFile imageFile) {
        try {
            // Check if the uploaded file is empty
            if (imageFile.isEmpty()) {
                throw new IllegalArgumentException("File is empty");
            }

            // Save image to a folder
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get("uploads/" + imageFile.getOriginalFilename());
            Files.write(path, bytes);

            // Save image path/name to resort in the database
            return "Image uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload image";
        } catch (IllegalArgumentException e) {
            return "Failed to upload image: " + e.getMessage();
        }
    }

    public Resort updateResort(Long id, Resort updatedResort) {
        Resort existingResort = resortRepository.findById(id)
                .orElseThrow();

        // Update fields of existingResort with fields of updatedResort
        existingResort.setName(updatedResort.getName());
        existingResort.setContactNumber(updatedResort.getContactNumber());
        existingResort.setEmail(updatedResort.getEmail());
        existingResort.setAddressLine1(updatedResort.getAddressLine1());
        existingResort.setAddressLine2(updatedResort.getAddressLine2());
        existingResort.setCity(updatedResort.getCity());
        existingResort.setDistrict(updatedResort.getDistrict());
        existingResort.setState(updatedResort.getState());
        existingResort.setPostalCode(updatedResort.getPostalCode());
        existingResort.setCountry(updatedResort.getCountry());
        existingResort.setLogo(updatedResort.getLogo());
        existingResort.setWebsite(updatedResort.getWebsite());
        existingResort.setTermsAndConditions(updatedResort.getTermsAndConditions());

        // Save the updated resort
        return resortRepository.save(existingResort);
    }
    public void deleteResort(Long id) {
        resortRepository.deleteById(id);
    }
}
