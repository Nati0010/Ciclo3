package com.misiontic.celuplanet.services.interfaces;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service

public interface IcloudinaryService {
	public Map<?, ?> upload(MultipartFile multipartFile) throws IOException;
	public Map<?, ?> delete(String id) throws IOException;
	public File convert(MultipartFile multipartFile) throws IOException;
}
