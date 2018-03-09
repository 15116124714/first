package com.offcn.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fruits {

	private String name;
	private double min;
	private double avg;
	private double max;
	private String spec;//规格
	private String unit;//单位
	private Date time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public Date getTime() {
		
		return time;
	}
	public void setTime(Date time) {
		
		this.time = time;
	}
	
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		String stime = sf.format(time);
		return "Fruits [name=" + name + ", min=" + min + ", avg=" + avg
				+ ", max=" + max + ", time=" + stime + "]";
	}
	
	
}
