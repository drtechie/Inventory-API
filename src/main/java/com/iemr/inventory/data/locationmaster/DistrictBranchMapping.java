package com.iemr.inventory.data.locationmaster;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.inventory.utils.mapper.OutputMapper;

@Entity
@Table(name = "m_DistrictBranchMapping")
public class DistrictBranchMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DistrictBranchID")
	@Expose
	private Integer districtBranchID;

	@Column(name = "BlockID")
	@Expose
	private Integer blockID;
	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "BlockID")
	private DistrictBlock districtBlock;
	
	@Expose
	@Transient
	private String blockName;

	@Column(name = "PanchayatName")
	@Expose
	private String panchayatName;
	@Column(name = "VillageName")
	@Expose
	private String villageName;
	@Column(name = "Habitat")
	@Expose
	private String habitat;
	@Column(name = "PinCode")
	@Expose
	private String pinCode;
	
	@Column(name = "govVillageID")
	@Expose
	private Integer govVillageID;
	
	@Column(name = "govSubDistrictID")
	@Expose
	private Integer govSubDistrictID;
	
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	

	public DistrictBranchMapping() {
	}

	public DistrictBranchMapping(Integer DistrictBranchID, String VillageName) {
		this.districtBranchID = DistrictBranchID;
		this.villageName = VillageName;
	}
	
	

	public DistrictBranchMapping(Integer districtBranchID, Integer blockID, String blockName, String panchayatName, String villageName,
			String habitat, String pinCode, Integer govVillageID, Integer govSubDistrictID, Boolean deleted) {
		super();
		this.districtBranchID = districtBranchID;
		this.blockID = blockID;
		this.panchayatName = panchayatName;
		this.villageName = villageName;
		this.habitat = habitat;
		this.pinCode = pinCode;
		this.govVillageID = govVillageID;
		this.govSubDistrictID = govSubDistrictID;
		this.deleted = deleted;
		this.blockName = blockName;
	}

	public DistrictBranchMapping(Integer DistrictBranchID, String VillageName, String PanchayatName, String Habitat,
			String PinCode) {
		this.districtBranchID = DistrictBranchID;
		this.villageName = VillageName;
		this.panchayatName = PanchayatName;
		this.habitat = Habitat;
		this.pinCode = PinCode;
	}

	public Integer getDistrictBranchID() {
		return this.districtBranchID;
	}

	public void setDistrictBranchID(int districtBranchID) {
		this.districtBranchID = Integer.valueOf(districtBranchID);
	}

	public Integer getBlockID() {
		return this.blockID;
	}

	public void setBlockID(int blockID) {
		this.blockID = Integer.valueOf(blockID);
	}

	public String getPanchayatName() {
		return this.panchayatName;
	}

	public void setPanchayatName(String panchayatName) {
		this.panchayatName = panchayatName;
	}

	public String getVillageName() {
		return this.villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getHabitat() {
		return this.habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Boolean isDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = Boolean.valueOf(deleted);
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return this.lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Integer getGovVillageID() {
		return govVillageID;
	}

	public void setGovVillageID(Integer govVillageID) {
		this.govVillageID = govVillageID;
	}

	public Integer getGovSubDistrictID() {
		return govSubDistrictID;
	}

	public void setGovSubDistrictID(Integer govSubDistrictID) {
		this.govSubDistrictID = govSubDistrictID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void setBlockID(Integer blockID) {
		this.blockID = blockID;
	}
	
	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}