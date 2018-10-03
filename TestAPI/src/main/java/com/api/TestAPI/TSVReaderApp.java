package com.api.TestAPI;

import java.util.List;

import spark.Request;
import spark.Response;
import spark.utils.StringUtils;

import static spark.Spark.get;

public class TSVReaderApp 
{
    public static void main( String[] args )
    {
    	get("/sightings", (req, res) -> getAll(req, res));
    }
    
    public static List<ReadDTO> getAll(Request req, Response res) {
    	
    	String month = req.queryParams("month");
    	String year = req.queryParams("year");
    	
    	SightingsImpl simpl = new SightingsImpl();
    	
    	if (StringUtils.isNotBlank(year) && (StringUtils.isNotBlank(month))) {
    		
		return simpl.getByMonthAndYear(month, year);
		} else {
			return simpl.getAll();
		}
    }
}
