package com.misiontic.celuplanet.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.misiontic.celuplanet.models.cellphoneDTOrequest;
import com.misiontic.celuplanet.models.cellphoneDTOresponse;
import com.misiontic.celuplanet.models.cellphoneModel;
import com.misiontic.celuplanet.repositories.cellphoneRepository;
import com.misiontic.celuplanet.services.interfaces.IcellphoneService;
import com.misiontic.celuplanet.services.interfaces.IcloudinaryService;

@Service

public class cellphoneServiceImplement implements IcellphoneService{
	
	@Autowired
	private cellphoneRepository repositorycell;
	
	@Autowired
	private IcloudinaryService cloudinaryService;
	
	@Override
	public List<cellphoneDTOresponse> getCells() {
		List<cellphoneModel> cellphoneList = repositorycell.findAll();
		List<cellphoneDTOresponse> cellphoneDTOList = new ArrayList<>();
		for (cellphoneModel cellphoneModel : cellphoneList) {
			cellphoneDTOresponse cellPhone = new cellphoneDTOresponse();
			cellPhone.setBrand(cellphoneModel.getBrand());
			cellPhone.setImage(cellphoneModel.getImage());
			cellPhone.setModel(cellphoneModel.getModel());
			cellPhone.setVersion(cellphoneModel.getVersion());
			cellPhone.setNumberReference(cellphoneModel.getNumberReference());
			
			cellphoneDTOList.add(cellPhone);
		}
		return cellphoneDTOList;
	}

	@Override
	public List<cellphoneDTOresponse> getCellsByModels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveCellphone(cellphoneDTOrequest cell) {
		try {
			Map<?,?> result = this.cloudinaryService.upload(cell.getImage());
			cellphoneModel cellModel = new cellphoneModel();
			cellModel.setBrand(cell.getBrand());
			cellModel.setFillNameImage((String) result.get("original_filename"));
			cellModel.setImage((String) result.get("url"));
			cellModel.setModel(cell.getModel());
			cellModel.setPublicIdImage((String) result.get("public_id"));
			cellModel.setVersion(cell.getVersion());
			this.repositorycell.save(cellModel);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public cellphoneDTOresponse getCellsById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteCellsById(Integer numberReference) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
