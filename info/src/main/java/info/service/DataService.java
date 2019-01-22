package info.service; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import java.util.List;
import java.util.Date;

import info.mapper.DataMapper;
import info.domain.Data;

@Service
public class DataService {
    
    @Autowired
    private DataMapper dataMapper;
    
    @Autowired
    Gson gson;
    
    
    
    @Transactional
    public String getData(Date start,Date end) {
        List<Data>datas=dataMapper.getData(start,end);
        if(datas.size()>0){
            long firstId=datas.get(0).getId();
            long endId=datas.get(datas.size()-1).getId()+99;            
            List<Data>returnDatas=dataMapper.getDataById(firstId,endId);
            double[]list=new double[returnDatas.size()];
            long[]labels=new long[list.length];
            for(int i=0;i<list.length;i++){
                Date date=returnDatas.get(i).getTime();
                if(date!=null){
                    labels[i]=date.getTime();
                }else{
                    labels[i]=0;
                }
                list[i]=returnDatas.get(i).getData();
            }
            return "{\"list\":"+gson.toJson(list)+",\"labels\":"+gson.toJson(labels)+"}";
        }else{
            return "{\"state\":\"error\"}";
        }
    }
}
