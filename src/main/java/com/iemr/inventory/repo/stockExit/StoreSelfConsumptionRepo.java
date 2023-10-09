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
package com.iemr.inventory.repo.stockExit;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.iemr.inventory.repo.BaseCrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.inventory.data.stockExit.StoreSelfConsumption;

@Repository
@RestResource(exported = false)
public interface  StoreSelfConsumptionRepo extends BaseCrudRepository<StoreSelfConsumption,Long>{

	List<StoreSelfConsumption> findByFacilityIDAndCreatedDateBetweenOrderByCreatedDateDesc(Integer facilityID,Timestamp fromDate,Timestamp toDate);
	
	@Transactional
	@Modifying
	@Query("update StoreSelfConsumption p set p.vanSerialNo=p.consumptionID where p.vanSerialNo is null and p.consumptionID>0")
	Integer updateVanSerialNo();
}