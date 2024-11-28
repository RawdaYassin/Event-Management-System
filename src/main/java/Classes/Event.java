
package Classes;

import java.util.Date;


public class Event {
    
private static int count = 0;
private final String id;
private String eventTitle;
private  Date eventDate;
private String venue;
private String cost;
private String description;
FileHandling fileEventDetails;

public Event()
{
    count++;
    this.id = "EV"+count; 
    this.fileEventDetails = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Events\\"+this.id+".txt");

}

public String getEventTitle(){
return fileEventDetails.readLine(1);
}
public void setEventTitle(String eventTitle){
this.eventTitle = eventTitle;
fileEventDetails.appendLine(2, this.eventTitle);
}
public String getEventDate(){
   
return fileEventDetails.readLine(2);
}
public void setEventDate(Date eventDate){
this.eventDate=eventDate;
fileEventDetails.appendLine(2, this.eventDate+"");
}
public String getVenue(){
    

return fileEventDetails.readLine(3);
}
public void setVenue(String venue){
    this.venue=venue;
fileEventDetails.appendLine(3, this.venue);
}

public String getDescription(){
 return  fileEventDetails.readLine(4);
}

public void setDescription(String description) {
    this.description=description;
    fileEventDetails.appendLine(4, this.description);
}

public void setCost(String cost) {
    this.cost=cost;
    fileEventDetails.appendLine(5, this.cost);
}

public String getCost(){
 return  fileEventDetails.readLine(5);
}

}
    
    

