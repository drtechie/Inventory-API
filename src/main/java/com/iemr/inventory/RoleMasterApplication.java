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
package com.iemr.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.iemr.inventory.utils.IEMRApplBeans;
import com.iemr.inventory.utils.config.ConfigProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
public class RoleMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(roleMasterApplication, args);
	}

/*	@Bean*/
	public ConfigProperties configProperties() {
		return new ConfigProperties();
	}

	@Bean
	public IEMRApplBeans instantiateBeans() {
		return new IEMRApplBeans();
	}

	private static Class<RoleMasterApplication> roleMasterApplication = RoleMasterApplication.class;

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(new Class[] { RoleMasterApplication.class });
	}
}
