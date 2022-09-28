package com.misiontic.celuplanet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misiontic.celuplanet.models.cellphoneModel;

public interface cellphoneRepository extends JpaRepository<cellphoneModel, Integer>{
	
	List<cellphoneModel> findByModelContaining(String model);
	
}
