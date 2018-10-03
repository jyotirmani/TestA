package com.api.TestAPI;

import java.io.IOException;
import java.util.List;

public interface Sightings {
	
	public List<ReadDTO> getAll();
	
	public List<ReadDTO> getByMonthAndYear(String month, String year);

}
