package com.misiontic.celuplanet.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="Cellphones")


public class cellphoneModel {
	private String image;
	private String brand;
	private String model;
	private String version;
	private String fillNameImage;
	private String publicIdImage;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numberReference ;
	
	
}
