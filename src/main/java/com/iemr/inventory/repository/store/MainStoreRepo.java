/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.inventory.repository.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.iemr.inventory.repo.BaseCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;


import com.iemr.inventory.data.store.M_Facility;
import com.iemr.inventory.data.supplier.M_Supplier;

@Repository
@RestResource(exported = false)
public interface MainStoreRepo extends BaseCrudRepository<M_Facility, Integer>{
	
	List<M_Facility> findByProviderServiceMapID(Integer providerServiceMapID);
    
	@Query("SELECT u FROM M_Facility u WHERE u.providerServiceMapID=:providerServiceMapID AND u.isMainFacility=:isMainFacility AND deleted=0")
	ArrayList<M_Facility> getAllMainFacility(@Param("providerServiceMapID")Integer providerServiceMapID,@Param("isMainFacility") Boolean isMainFacility);
	
	
	@Query("SELECT u FROM M_Facility u WHERE u.providerServiceMapID=:providerServiceMapID AND u.isMainFacility=:isMainFacility AND u.mainFacilityID=:mainFacilityID AND deleted=0")
	ArrayList<M_Facility> getAllMainFacility(@Param("providerServiceMapID")Integer providerServiceMapID,@Param("isMainFacility") Boolean isMainFacility,
			@Param("mainFacilityID") Integer mainFacilityID);

	@Query("SELECT u FROM M_Facility u WHERE u.providerServiceMapID=:providerServiceMapID AND u.mainFacilityID=:mainFacilityID AND deleted=0")
	ArrayList<M_Facility> getChildFacility(@Param("providerServiceMapID")Integer providerServiceMapID,@Param("mainFacilityID") Integer mainFacilityID);
	
	
	ArrayList<M_Facility> findByMainFacilityIDAndDeleted(Integer mainfacID,Boolean deleted);
	
	M_Facility findByFacilityIDAndDeleted(Integer mainfacID,Boolean deleted);
	
	
	List<M_Facility> findByProviderServiceMapIDAndDeleted(Integer pp,Boolean delete);
	
//	@Transactional
//	@Modifying
//	@Query("UPDATE M_Facility c SET c.quantityInHand = :quant WHERE c.itemStockEntryID = :id")
//	Integer updateStoreMap(@Param("id") Integer facid, @Param("pp") Integer parkingPlaceID,@Param("type")String type);


}
