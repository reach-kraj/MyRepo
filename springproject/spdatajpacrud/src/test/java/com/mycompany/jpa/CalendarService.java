package com.mycompany.jpa;

import java.util.List;

public interface CalendarService {
	public List<String> getMeetings(String user);  
    public void deleteMeeting(String meetString); 
}
