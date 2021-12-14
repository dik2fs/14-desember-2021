package com.rsudalihsan.ibs.model;

import com.google.gson.annotations.SerializedName;

public class IbsDataItem {

	@SerializedName("nama_pasien")
	private String namaPasien;

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("nomor_urut")
	private String nomorUrut;

	@SerializedName("nomor_medrek")
	private String nomorMedrek;

	@SerializedName("id")
	private String id;

	@SerializedName("waktuinput")
	private String waktuinput;

	@SerializedName("ok")
	private String ok;

	@SerializedName("operator")
	private String operator;

	public void setNamaPasien(String namaPasien){
		this.namaPasien = namaPasien;
	}

	public String getNamaPasien(){
		return namaPasien;
	}

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return keterangan;
	}

	public void setNomorUrut(String nomorUrut){
		this.nomorUrut = nomorUrut;
	}

	public String getNomorUrut(){
		return nomorUrut;
	}

	public void setNomorMedrek(String nomorMedrek){
		this.nomorMedrek = nomorMedrek;
	}

	public String getNomorMedrek(){
		return nomorMedrek;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setWaktuinput(String waktuinput){
		this.waktuinput = waktuinput;
	}

	public String getWaktuinput(){
		return waktuinput;
	}

	public void setOk(String ok){
		this.ok = ok;
	}

	public String getOk(){
		return ok;
	}

	public void setOperator(String operator){
		this.operator = operator;
	}

	public String getOperator(){
		return operator;
	}
}