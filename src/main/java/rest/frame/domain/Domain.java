package rest.frame.domain;

import com.google.gson.annotations.SerializedName;

public class Domain {
	//This need to be given in rest body with json
	/**
	 * {"input" : "what ever data"}
	 */
	@SerializedName("dataIn")
	private String dataIn;

	public String getDataIn() {
		return dataIn;
	}

	public void setDataIn(String dataIn) {
		this.dataIn = dataIn;
	}
	
}
