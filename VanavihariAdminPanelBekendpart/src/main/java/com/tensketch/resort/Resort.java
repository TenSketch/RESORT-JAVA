package com.tensketch.resort;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity

@Setter
public class Resort {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String contactNumber;

	private String email;

	private String addressLine1;

	private String addressLine2;

	private String city;

	private String district;

	private String state;

	private String postalCode;

	private String country;

	private String logo; // URL or file path to the logo

	private String website;

	private String termsAndConditions; // For invoice

//	public Object getDescription() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setDescription(Object description) {
//		// TODO Auto-generated method stub
//		
//	}

	// Getters and setters
	
//
//    public Resort() {
//        // Default constructor required by JPA
//    }
//
//    public Resort(String name) {
//        this.name = name;
//    }
}
