package com.tensketch.resort1;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.Deflater;

@RestController
@RequestMapping("/api/resort1")
public class Resort1Controller {

    private final Resort1Service resort1Service;
    private final ObjectMapper objectMapper;

    @Autowired
    public Resort1Controller(Resort1Service resort1Service, ObjectMapper objectMapper) {
        this.resort1Service = resort1Service;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity<?> addResort1Information(
            @RequestPart("imageLogo") MultipartFile file,
            @RequestPart("conditionForInvoice") MultipartFile file1,
            @RequestPart("userData") String userData
    ) throws IOException {
        // Convert JSON string to User object
        Resort1 resort1;
        try {
            resort1 = objectMapper.readValue(userData, Resort1.class);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request");
        }

        // Store file content in the user entity
        if (file1 != null && !file1.isEmpty()) {
            resort1.setImageLogo(file1.getBytes());
        }
        if (file != null && !file.isEmpty()) {
            resort1.setConditionForInvoice(file.getBytes());
        }

        // Save user to database
        Resort1 savedresort1 = resort1Service.addResort1(resort1);
        return ResponseEntity.ok(savedresort1);
    }
    
    
//    
//    @PostMapping
//    public ResponseEntity<?> addResort1Information(
//            @RequestPart("imageLogo") MultipartFile file,
//            @RequestPart("conditionForInvoice") MultipartFile file1,
//            @RequestPart("userData") String userData
//    ) throws IOException {
//        // Convert JSON string to Resort1 object
//        Resort1 resort1;
//        try {
//            resort1 = objectMapper.readValue(userData, Resort1.class);
//        } catch (JsonProcessingException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request");
//        }
//
//        // Ensure that file and file1 are not null
//        if (file1 == null || file == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Both imageLogo and conditionForInvoice files are required.");
//        }
//
//        // Compress file content before storing in the resort1 entity
//        byte[] compressedImageLogo = compressFile(file1);
//        byte[] compressedConditionForInvoice = compressFile(file);
//
//        resort1.setImageLogo(compressedImageLogo);
//        resort1.setConditionForInvoice(compressedConditionForInvoice);
//
//        // Save resort1 to the database
//        Resort1 savedResort1 = resort1Service.addResort1(resort1);
//        return ResponseEntity.ok(savedResort1);
//    }
//
//    // Method to compress file content
//    private byte[] compressFile(MultipartFile file) throws IOException {
//        byte[] fileContent = file.getBytes();
//        Deflater deflater = new Deflater();
//        deflater.setInput(fileContent);
//        deflater.finish();
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(fileContent.length);
//        byte[] buffer = new byte[1024];
//        while (!deflater.finished()) {
//            int count = deflater.deflate(buffer);
//            outputStream.write(buffer, 0, count);
//        }
//        outputStream.close();
//        byte[] compressedData = outputStream.toByteArray();
//        deflater.end();
//        return compressedData;
//    }
    
    
    
    
    
    
	// Get all resorts
    @GetMapping
    public ResponseEntity<List<Resort1>> getAllResorts() {
        List<Resort1> resorts = resort1Service.getAllResorts();
        return ResponseEntity.ok(resorts);
    }

    // Get resort by ID
    @GetMapping("/{id}")
    public ResponseEntity<Resort1> getResortById(@PathVariable Long id) {
        Optional<Resort1> resortOptional = resort1Service.getResortById(id);
        return resortOptional.map(resort -> ResponseEntity.ok().body(resort))
                              .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update resort by ID
    @PutMapping("/{id}")
    public ResponseEntity<Resort1> updateResortById(@PathVariable Long id,
                                                    @RequestBody Resort1 updatedResort1) {
        Resort1 updatedResort = resort1Service.updateResortById(id, updatedResort1);
        return ResponseEntity.ok(updatedResort);
    }

    // Delete resort by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResortById(@PathVariable Long id) {
        resort1Service.deleteResortById(id);
        return ResponseEntity.noContent().build();
    }
   
}

