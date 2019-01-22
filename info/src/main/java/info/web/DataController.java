package info.web; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;

import java.util.Date;

import info.service.DataService;

@Controller
public class DataController {
 
    @Autowired
    DataService dataService; 
    
    @RequestMapping(value = { "/data"},method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getData(@RequestParam("start")long  start,@RequestParam("end")long end) {
        /*
        select * from hockey_stats
        where game_date between '2012-03-11 00:00:00' and '2012-05-11 23:59:00'
        */
        return dataService.getData(new Date(start),new Date(end));
    }
}
