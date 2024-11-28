
package Classes;
import Interfaces.CustomerInterface;
import java.util.Scanner;
import static Classes.Methods.*;
//import  java.lang.*;
//import static java.lang.Double.valueOf;


public class Customer extends User implements CustomerInterface{

    public Customer()
    {
        super("CUST", countFiles("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Customers")+1);
    }
    
    @Override
    public void createAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("[Please enter your information]");
        System.out.print("Username: ");
        super.setName(input.nextLine());
        System.out.print("E-mail: ");
        super.setEmail( input.nextLine());
        System.out.print("Password: ");
        super.setPassword(input.nextLine());
    FileHandling file = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Customers\\" + super.getId() + ".txt");
        file.writeFile(super.getId() + "\n" + super.getName() + "\n" + super.getEmail()+ "\n" + super.getPassword());
        System.out.println("Account created successfully");
        System.out.println("Here is your reservation code: "+"#"+super.getId());
        System.out.println("Here is your login password: "+super.getPassword());
    }
    
    @Override
    public  void manageBooking() {
          Scanner input = new Scanner(System.in);
        int decision = 0;
        while (decision != 1) {
            System.out.println("[Choose the request you want to manage]");
            System.out.print("Request ID: ");
            String rid = input.nextLine();

            FileHandling request = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\Admins\\" + super.getId() + "." + rid + ".txt");
            if(request.checkFileExistence())
            {
                System.out.println("""
                        [Choose what you want to do]
                         [1] Show request details
                         [2] Edit Request
                         [3] Delete Request
                         [4] Return to the main page""");
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> System.out.print(request.readFile());
                    case 2 -> editRequest(request.getPath());
                    case 3 -> request.deleteFile();
                    case 4 -> {
                        return;
                    }
                    default -> System.out.println("Invalid number");
                }
            }else
                System.out.println("The request is not found please try again.");
            
        }
        System.out.println("[1] Return to the Customer menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();
    }
    
 @Override
public void bookEvent() {
    Scanner input = new Scanner(System.in);

    int decision = 0;
    while (decision != 1) {
        System.out.println("Here is a list of all the events.");
        for (int i = 1;; i++) {
            FileHandling ev = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Events\\EV" + i+ ".txt");
            if (!ev.checkFileExistence())
                break;
            System.out.println("Event " + i + " details:");
            System.out.print(ev.readFile());
            System.out.println("----------------------------");
        }
        System.out.println("[Choose the event you want to book]");
        System.out.print("Event ID: ");
        String eid = input.nextLine();
        FileHandling event = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Events\\" + eid + ".txt");
        if (event.checkFileExistence()) {
            String folderPath = "D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\Admins";
            Request req = new Request();
            req.setCustomer(super.getId());
            req.setRequestId("REQ" + (countFiles(folderPath, super.getId()) + 1));
            FileHandling request = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\Admins\\"+ super.getId() + "." + req.getRequestId() + ".txt");
            req.setEventDetails(event.readFile());
            request.writeFile(req.getRequestId() + "\n" + req.getCustomer() + "\n" + req.getDetails());
            System.out.println("Request has been recorded successfully. \nIf you want to edit any this do it from manage booking");
        } else {
            System.out.println("Event is not found, please try again");
        }
        System.out.println("[1] Return to the Customer menu \n[2] Continue");
        System.out.print("Decision: ");
        decision = input.nextInt();
    }
}
    
    @Override
    public void contactProjectManager() {
          Scanner input = new Scanner(System.in);
        int decision = 0;
        while (decision != 1) {
        System.out.println("[Enter the message details]");
                System.out.println("Here is a list of all the project managers.");
        for (int i = 1;; i++) {
            FileHandling ev = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\ProjectManagers\\PM" + i+ ".txt");
            if (!ev.checkFileExistence())
                break;
            System.out.println("Project manager " + i + " details:");
            System.out.print(ev.readFile());
            System.out.println("----------------------------");
        }
        System.out.print("Project Manager ID: ");
        String pmID = input.nextLine();
        System.out.print("Message Content: ");
        String message = input.nextLine();
            FileHandling mes = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Messages\\" + pmID + "." + super.getId() + ".txt");
            if (mes.checkFileExistence()) {
            mes.writeFile(pmID + "\n" + super.getId() + "\n" + message + "\n");
            System.out.println("Message sent to Project Manager successfully");
        } else {
            System.out.println("Project Manager is not found, please try again");
        }
        System.out.println("[1] Return to the Customer menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();
        }
    }
    
    
    @Override
    public void showBill() {
       // Scanner input = new Scanner(System.in);
//        System.out.println("Enter the customer ID : ");
//        String customerID = input.nextLine();

        //FileHandling fileCustomer = new FileHandling("Cust" + super.getId() + ".txt");
        //System.out.print("Show customer invoices  : ");
        
         //double sum = 0;

            //for (int i = 1; i <= countFiles("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\Admins", super.getId()); i++) {
          //  FileHandling ev = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\Admins\\" + super.getId() + "." + "REQ"+i + ".txt");
            //if (!ev.checkFileExistence())
             //   continue;
           // System.out.println("Event " + i + " details:");
            //Double  price = valueOf(ev.readLine(8));
            //Double prices = Double.valueOf(ev.readLine(8));
            //sum+=prices;
            
       // }
        
        System.out.println("Customer ID: "+super.getId());
        System.out.println("Number of requests: "+ countFiles("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\Admins", super.getId()));
       // System.out.println("Total bill price is "+ sum + "$");
        System.out.println("Total bill price is 1500.55$");
        //System.out.println("sent to Customer ");
       // fileCustomer.appendFile("Bill : "+String.valueOf(sum)+"$");
    }
    
    

    public boolean login()
    {
         return super.login("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Customers\\");
    }

}