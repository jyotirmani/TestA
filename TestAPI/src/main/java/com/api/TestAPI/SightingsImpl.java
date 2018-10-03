package com.api.TestAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SightingsImpl implements Sightings {

	public List<ReadDTO> getAll() {
		String dataRow = null;
		StringTokenizer st ;
		InputStream inputStream = TSVReaderApp.class.getClass().getResourceAsStream("/users.tsv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		List<ReadDTO> dtolist = new ArrayList<>();
		
		ReadDTO dto;
		
		try {
			dataRow = reader.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (dataRow != null) {
			try {
				st = new StringTokenizer(dataRow,"\t");
				List<String>dataArray = new ArrayList<String>() ;
	            while(st.hasMoreElements()){
	                dto = new ReadDTO();
	                dto.setYear(st.nextElement().toString());
					dto.setMonth(st.nextElement().toString());
					dto.setData(st.nextElement().toString());
					dtolist.add(dto);
	            }
	            for (String item:dataArray) { 
	                System.out.print(item + "  "); 
	            }
	            
	            System.out.println();
	            dataRow = reader.readLine();
				System.out.println(dtolist.toString());
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtolist;
	
	}

	@Override
	public List<ReadDTO> getByMonthAndYear(String month, String year) {
		List<ReadDTO> dtolist = getAll();
		List<ReadDTO> filterdDTOList = new ArrayList<>();
		System.out.println(month+" "+year);
		for (ReadDTO dto : dtolist) {
			System.out.println("Month--"+dto.getMonth());
			System.out.println("year-----------"+dto.getYear());
			if (month.equalsIgnoreCase(dto.getMonth()) && year.equalsIgnoreCase(dto.getYear())) {
				filterdDTOList.add(dto);
			}
		}
		return filterdDTOList;
	}

}
