
package Classes;

import java.time.LocalDate;
import java.util.*;
import Interfaces.ServiceProviderInterface;


public  class ServiceProvider extends User implements ServiceProviderInterface{
        
private static int count = 1;
    public ServiceProvider()
    {
        super("SA", count);
         count++;
    }
    
    @Override
    public  void receiveRequest()
    {
      Scanner input = new Scanner(System.in);
        System.out.println("Enter Customer ID :");
        String CustomerID=input.nextLine();
        System.out.println("Enter Request ID");
        String IDRequest=input.nextLine();

 FileHandling reveiveCustomer=new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\ServiceProviders\\"+CustomerID+"."+IDRequest+".txt");
        if(reveiveCustomer.checkFileExistence())
            System.out.println("Request received successfully");
        else 
            System.out.println("Error occurr while receiving, please try again.");

    }
    
    @Override
    public void priceRequest() 
    {
//                for (int i = 1;; i++) {
//            FileHandling ev = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\CUST" + i+ +".REQ"+i+".txt");
//            if (!ev.checkFileExistence())
//                break;
//            System.out.println("Event " + i + " details:");
//            System.out.print(ev.readFile());
//            System.out.println("----------------------------");
//        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Customer ID :");
        String CustomerID = input.nextLine();
        System.out.println("Enter Request ID");
        String RequestID = input.nextLine();
        FileHandling reveiveCustomer = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\ServiceProviders\\" + CustomerID + "." + RequestID + ".txt");
        if (reveiveCustomer.checkFileExistence()){

            Random random = new Random();
            int hour = random.nextInt(10) + 1;
            //System.out.println(" number of hour = " + hour);
            //System.out.println("Enter your Cost : ");
            Integer Cost = Integer.valueOf(reveiveCustomer.readLine(8));
            int Bill = Cost * hour;
            //System.out.println("Bill of Request = " + Bill);
            //System.out.println("sent To File  ProjectManger ......");
            //reveiveCustomer.appendFile("Bill of Request " + RequestID + " : " + Bill + "$");
            reveiveCustomer.appendLine(8, Bill+"");
            System.out.println("The price of the request is calculated successfully");
        }else
            System.out.println("Request is not found please try again.");
    }
    
    @Override
    public void determineReadyDate()
    {
Scanner input = new Scanner(System.in);
        System.out.print("Customer ID :");
        String CustomerID=input.nextLine();
        System.out.print("Request ID : ");
        String RequestID=input.nextLine();
        FileHandling reveiveCustomer=new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\ServiceProviders\\"+CustomerID+"."+RequestID+".txt");
        if(reveiveCustomer.checkFileExistence())
        {
            LocalDate currentDate = LocalDate.now();
            String newd = currentDate.plusDays(5).toString();
            reveiveCustomer.appendLine(9,newd);
            System.out.println("Date of Request is determined successfully.");
            System.out.println("Date of Request : "+currentDate);
            System.out.println("Ready date of request:" + reveiveCustomer.readLine(9));

        }else
            System.out.println("Request is not found please try again.");
    }
    
    public boolean login()
    {
        return super.login("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\ServiceProviders\\");
    } 

    
}