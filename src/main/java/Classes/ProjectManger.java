
package Classes;
import Interfaces.ProjectManagerInterface;
import java.util.Scanner;

public class ProjectManger extends User  implements ProjectManagerInterface  {

private static int count = 1;
    public ProjectManger()
    {
        super("PM", count);
         count++;
    }
    
    @Override
    public void receiveRequests() {
       Scanner input = new Scanner(System.in);
        int decision = 0;
        while (decision != 1){
            for (int i = 1;; i++) {
            FileHandling ev = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\Admins" + i+ ".txt");
            if (!ev.checkFileExistence())
                break;
            System.out.println("Requests " + i + " details:");
            System.out.print(ev.readFile());
            System.out.println("----------------------------");
        }
            System.out.println("Enter the customer ID to receive : ");
            String customerID = input.nextLine();
            System.out.println("Enter the Request number to receive it:  ");
            String  idRequest = input.nextLine();      

            FileHandling fileRequest = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\ProjectMangers\\" + customerID + "." + idRequest + ".txt");
            if (fileRequest.checkFileExistence()) {
                System.out.println("\nRequests received successfully\n---------------------\n");
            } else {
                System.out.println("\nError occurr while receiving\n ---------------------------------\n");
            }
                System.out.println("[1] Return to the Project manager menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();
        }
    }


    @Override
    public void sendRequests(){
        Scanner input = new Scanner(System.in);
        int decision = 0;
        while (decision != 1)
        {
//            for (int i = 1;; i++) {
//            FileHandling ev = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\ProjectManagers\\PM" + i+ ".txt");
//            if (!ev.checkFileExistence())
//                break;
//            System.out.println("Request " + i + " details:");
//            System.out.print(ev.readFile());
//            System.out.println("----------------------------");
//        }
            System.out.println("Enter the customer ID  to send: ");
            String customerID = input.nextLine();
            System.out.println("Enter the Request number to send it:  ");
            String  idRequest = input.nextLine();

            FileHandling fileRequest = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\ProjectMangers\\" + customerID + "." + idRequest + ".txt");
            if (fileRequest.checkFileExistence() )
            {
                System.out.println("\n request send to SP\n---------------------\n");
                fileRequest.copyFile("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\ServiceProviders\\" + customerID + "." + idRequest + ".txt");
            }else
                System.out.println("\nRequest is not found, please try again\n ---------------------------------\n");

           System.out.println("[1] Return to the Project manager menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt(); 
        }

    }
    
    
@Override
 public void contactCustomer() {
    Scanner input = new Scanner(System.in);
   
        int decision = 0;
        while (decision != 1) {
        System.out.println("[Enter the message details]");
        System.out.print("Enter the customer ID to contact: ");
        //input.nextLine(); // Consume the newline character
        String customerID = input.nextLine();
        FileHandling fileCustomer = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Messages\\" + super.getId() + "." + customerID + ".txt");
        System.out.println("1-Send a message to the customer\n2-Show customer messages");
        int choice = input.nextInt();
        //input.nextLine(); // Consume the newline character
        
        switch (choice) {
            case 1 -> {
                System.out.print("Message: ");
                String message = input.nextLine();
                fileCustomer.appendFile(message);
            }
            case 2 -> {
                System.out.println("------------chat_Customer" + customerID + "---------------");
                System.out.println("\n" + fileCustomer.readFile());
            }
            default -> System.out.println("Invalid number, please try again");
        }
                System.out.println("[1] Return to the Project manager menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();
    }
}
    
//@Override
//    public void showBill() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter the customer ID : ");
//        String customerID = input.nextLine();
//
//        FileHandling fileCustomer = new FileHandling("Cust" + customerID + ".txt");
//        System.out.print("Show customer invoices  : ");
//        int i = 1;
//        int sum = 0;
//        int j=1;
//        boolean fileExists = true;
//        while (fileExists) {
//            FileHandling fileRequest = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\Customers\\" + customerID + "." + "REQ"+i + ".txt");
//            String line ;
//            if(fileRequest.checkFileExistence()) {
//                while ((line = fileRequest.readLine(j)) != null) {
//                    try {
//                        int number = Integer.parseInt(line.trim());
//                        sum += number;
//                    } catch (NumberFormatException e) {
//
//                        System.out.println("Error: Invalid number format on line " + i + " in file Cust" + customerID + "." + i + ".txt");
//                    }
//                    j++;
//                }
//            }
//            else
//                fileExists=false;
//            i++;
//        }
//        System.out.println(sum);
//        System.out.println("sent to Customer ");
//        fileCustomer.appendFile("Bill : "+String.valueOf(sum)+"$");
//    }
    
    
    
    public boolean login()
    {
        return super.login("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\ProjectMangers\\");
    }
}
