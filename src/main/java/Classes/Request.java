
package Classes;

public class Request {
    
private static int count=0;
private String requestid;
private String customerid;
private String eventdetails;

//FileHandling fileRequest;

public Request()
{
    count++;
    this.requestid = "REQ"+count;
    //this.fileRequest=new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\Admins"+this.customerid+"."+this.requestid+".txt");
}

public String getRequestId(){
    return this.requestid;
  //return fileRequest.readLine(1);
}
public void  setRequestId(String requestid){
this. requestid=requestid;
//fileRequest.appendLine(1, this.requestid);
}
public String getCustomer(){
    return this.customerid;
 //return fileRequest.readLine(2);
}
public void  setCustomer(String customer){
    this.customerid=customer;
//fileRequest.appendLine(2, this.customerid );
}
public String getDetails(){
 return this.eventdetails;
//return fileRequest.readLine(3);
}
public void  setEventDetails(String details){
this. eventdetails=details;
//fileRequest.appendLine(3, this.eventdetails);
}

    
}
