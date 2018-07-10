package com.posco.test;

import java.util.ArrayList;

public class ComVO {
	
	private String comName;
	private String comPhone;
	private ArrayList<MemVO> memList;
	
	public String getComName() {return comName;}
	public String getComPhone() {return comPhone;}
	public ArrayList<MemVO> getMemList() {return memList;}
	
	public void setComName(String comName) {this.comName = comName;}
	public void setComPhone(String comPhone) {this.comPhone = comPhone;}
	public void setMemList(ArrayList<MemVO> memList) {this.memList = memList;}

}
