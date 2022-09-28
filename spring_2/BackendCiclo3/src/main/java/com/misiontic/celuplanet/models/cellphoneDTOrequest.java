package com.misiontic.celuplanet.models;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data

public class cellphoneDTOrequest {
	private MultipartFile image;
	private String brand;
	private String model;
	private String version;
}
