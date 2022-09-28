package com.misiontic.celuplanet.services.implement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.misiontic.celuplanet.services.interfaces.IcloudinaryService;

@Service

public class CloudinaryServiceImplement implements IcloudinaryService {

	@Value("${cloudinary.cloud_name}")
	private String cloud_name;
	
	@Value("${cloudinary.api_key}")
	private String api_key;
	
	@Value("${cloudinary.api_secret}")
	private String api_secret;
	
	public Cloudinary context () {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("cloud_name", cloud_name);
        valuesMap.put("api_key", api_key);
        valuesMap.put("api_secret", api_secret);
		return  new Cloudinary(valuesMap);
	}
	
	@Override
	public Map<?, ?> upload(MultipartFile multipartFile) throws IOException {
		 File file = this.convert(multipartFile);
	     Map<?, ?> result = this.context().uploader().upload(file, ObjectUtils.emptyMap());
	     file.delete();
	     return result;
	}

	@Override
	public Map<?, ?> delete(String id) throws IOException {
		Map<?, ?> result = this.context().uploader().destroy(id, ObjectUtils.emptyMap());
	     return result;
	}

	@Override
	public File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
	}
	
	
	
}
