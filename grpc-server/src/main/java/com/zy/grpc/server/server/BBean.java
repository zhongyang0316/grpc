package com.zy.grpc.server.server;

public class BBean {
	
	private String bName;
	
	private ABean aBean;

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public ABean getaBean() {
		return aBean;
	}

	public void setaBean(ABean aBean) {
		this.aBean = aBean;
	}

	@Override
	public String toString() {
		return "BBean [bName=" + bName + ", aBean=" + aBean + "]";
	}
	
}
