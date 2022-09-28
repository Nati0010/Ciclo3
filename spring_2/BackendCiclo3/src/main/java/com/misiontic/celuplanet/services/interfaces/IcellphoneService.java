package com.misiontic.celuplanet.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.misiontic.celuplanet.models.cellphoneDTOrequest;
import com.misiontic.celuplanet.models.cellphoneDTOresponse;

@Service

public interface IcellphoneService {
	
	List<cellphoneDTOresponse> getCells();
	List<cellphoneDTOresponse> getCellsByModels();
	Boolean saveCellphone(cellphoneDTOrequest cell);
	cellphoneDTOresponse getCellsById();
	Boolean deleteCellsById(Integer numberReference);
	
	
}
