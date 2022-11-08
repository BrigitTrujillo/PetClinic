package com.tecsup.petclinic.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 
 * @author jgomezm
 *
 */
public class PetDTO {

	private long id;
	
	private String name;
	
	private int typeId;

	private int ownerId;

	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",  timezone = "GMT+8")
	private Date birthDate;

	public PetDTO(String name, int typeId, int ownerId, Date birthDate) {
		super();
		this.name = name;
		this.typeId = typeId;
		this.ownerId = ownerId;
		this.birthDate = birthDate;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int type_id) {
		this.typeId = type_id;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int owner_id) {
		this.ownerId = owner_id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", typeId=" + typeId + ", ownerId=" + ownerId + ", birth_date="
				+ birthDate + "]";
	}

}
