package info.domain;

import java.io.Serializable;
import java.util.Date;

public class Data implements Serializable{
    private long id;
	public long getId(){
		return id;
	}
	public void setId(long id){
		this.id=id;
	}

    
    private Date time;
	public Date getTime(){
		return time;
	}
	public void setTime(Date time){
		this.time=time;
	}

    private double data;
	public double getData(){
		return data;
	}
	public void setData(double data){
		this.data=data;
	}
    
    
}
