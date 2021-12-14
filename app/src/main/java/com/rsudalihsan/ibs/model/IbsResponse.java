package com.rsudalihsan.ibs.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class IbsResponse {

	@SerializedName("metadata")
	private IbsMetadata ibsMetadata;

	@SerializedName("response")
	private List<IbsDataItem> response;

	public void setMetadata(IbsMetadata ibsMetadata){
		this.ibsMetadata = ibsMetadata;
	}

	public IbsMetadata getMetadata(){
		return ibsMetadata;
	}

	public void setResponse(List<IbsDataItem> response){
		this.response = response;
	}

	public List<IbsDataItem> getResponse(){
		return response;
	}
}