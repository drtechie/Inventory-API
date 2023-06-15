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
package com.iemr.inventory.data.user;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.iemr.inventory.utils.mapper.OutputMapper;


@Entity
@Table(name="m_ServiceProvider")
public class M_ServiceProvider {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private int ServiceProviderId; 
	 private String ServiceProviderName;
	 private Date JoiningDate;
	 private int StateId;
	 private String LogoFileName;
	 private String LogoFilePath;
	 private String PrimaryContactName;
	 private String PrimaryContactNo;
	 private String PrimaryContactEmailID;
	 private String PrimaryContactAddress;
	 private String PrimaryContactValidityTillDate;
	 private String SecondaryContactName;
	 private String SecondaryContactNo;
	 private String SecondaryContactEmailID;
	 private String SecondaryContactAddress;
	 private Date SecondaryContactValidityTillDate;
	 private int Deleted;
	 private String CreatedBy;
	 private java.util.Date CreatedDate;
	 private String ModifiedBy;
	 private java.util.Date LastModDate;
	 
	 
	 
	 @Transient
		private OutputMapper outputMapper = new OutputMapper();

		@Override
		public String toString() {
			return outputMapper.gson().toJson(this);
		}

}
