
package Pages;

import Classes.ServiceProvider;
import java.util.Scanner;

public class ServiceProviderPage {

    public static void main(String[] args) throws Exception{
        
        ServiceProvider serviceprovider = new ServiceProvider();
        Scanner input = new Scanner(System.in);
        if(serviceprovider.login()){
        int decision = 0;
        while (decision != 1){
                System.out.println("""
                        Hello, Service Provider!
                        Choose what you want to do?
                        [1] Receive customer requests from project manager
                        [2] Price the value of request and send to project manager
                        [3] Determine ready date for request            
                        """);
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> serviceprovider.receiveRequest();
                    case 2 -> serviceprovider.priceRequest();
                    case 3 -> serviceprovider.determineReadyDate();
                    default -> System.out.println("Invalid number.");
                }
                System.out.println("[1] Return to the roles menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();
            }
        }else{
            System.out.println("An error occurr while logging in, please check your account or try again.");
            //return;
        }
    }
    
}
