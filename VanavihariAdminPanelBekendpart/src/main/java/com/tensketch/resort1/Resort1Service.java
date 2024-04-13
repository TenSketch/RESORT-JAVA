package com.tensketch.resort1;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Resort1Service {

    private final Resort1Repository resort1Repository;

    @Autowired
    public Resort1Service(Resort1Repository resort1Repository) {
        this.resort1Repository = resort1Repository;
    }

    public Resort1 addResort1(Resort1 resort1) {
        return resort1Repository.save(resort1);
    }

    
    
    
 // Method to decompress file content
//    private byte[] decompressFile(byte[] compressedData) throws IOException {
//        return CompressionUtil.decompress(compressedData);
//    }
//
//    public Resort1 addResort1(Resort1 resort1) {
//        try {
//            // Decompress file content before saving to the database
//            byte[] decompressedImageLogo = decompressFile(resort1.getImageLogo());
//            resort1.setImageLogo(decompressedImageLogo);
//
//            byte[] decompressedConditionForInvoice = decompressFile(resort1.getConditionForInvoice());
//            resort1.setConditionForInvoice(decompressedConditionForInvoice);
//        } catch (IOException e) {
//            // Handle decompression exception
//        }
//
//        // Save resort1 to the database
//         resort1Repository.save(resort1);
//        return resort1;
//    }
    
    
    
    
    public List<Resort1> getAllResorts() {
        return resort1Repository.findAll();
    }

    public Optional<Resort1> getResortById(Long id) {
        return resort1Repository.findById(id);
    }

    public Resort1 updateResortById(Long id, Resort1 updatedResort1) {
        // Fetch the existing resort by ID
        Resort1 existingResort = resort1Repository.findById(id).orElse(null);
        if (existingResort == null) {
            // Resort not found, handle accordingly
            // For example, throw an exception or return null
            return null;
        }

        // Update the properties of the existing resort
//        existingResort.setName(updatedResort1.getName());
//        existingResort.setContactNumber(updatedResort1.getContactNumber());
        // Update other properties as needed...
     // Update the properties of the existing resort
        existingResort.setName(updatedResort1.getName());
        existingResort.setContactNumber(updatedResort1.getContactNumber());
        existingResort.setEmail(updatedResort1.getEmail());
        existingResort.setAddress(updatedResort1.getAddress());
        existingResort.setWebsite(updatedResort1.getWebsite());
        existingResort.setImageLogo(updatedResort1.getImageLogo());
        existingResort.setConditionForInvoice(updatedResort1.getConditionForInvoice());
        // Update other properties as needed...


        // Save the updated resort
        return resort1Repository.save(existingResort);
    }

    public void deleteResortById(Long id) {
        resort1Repository.deleteById(id);
    }
}

