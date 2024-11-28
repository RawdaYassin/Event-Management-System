
package Classes;

import java.io.File;
import java.util.Scanner;

public class Methods {

    
        public static void editRequest(String path)
    {
        Scanner input = new Scanner(System.in);
        FileHandling request = new FileHandling(path);
        System.out.println("Request details:");
        request.readFile();
        System.out.print("[Choose a new event to add");
        for (int i = 1; ; i++) {
            FileHandling ev = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Events\\EV" + i + ".txt");
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
            request.writeFile(request.readLine(1)+"\n"+request.readLine(2)+ "\n"+event.readFile() );
            System.out.println("Request edited successfully.");
        } else {
            System.out.println("Event is not found, please try again");
        }
    }
    
  
        public  static int countFiles(String folderPath, String partOfName) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        int count = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().contains(partOfName)) {
                    count++;
                }
            }
        }
        return count;
    }
        public  static int countFiles(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        int count = 0;

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().contains("")) {
                    count++;
                }
            }
        }
        return count;
    }
     
     public static void delete(String user, String path) {
         Scanner input = new Scanner(System.in);
             String idUser;
          System.out.println("Enter id "+user+": ");
                    idUser = input.nextLine();
                    FileHandling fileHandling = new FileHandling(path+ idUser + ".txt");
                    if (fileHandling.checkFileExistence())
                        fileHandling.deleteFile();
                    else
                        System.out.println(user+" is not found, please try again.");
     }

    public static void update(String user, String path) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter id " + user + ": ");
    String idUser = input.nextLine();
    FileHandling fileHandling = new FileHandling(path + idUser + ".txt");

    if (fileHandling.checkFileExistence()) {
        int ch = 0;
        while (ch != 1) {
            System.out.println("Update\n1-Name\n2-Password");
            int updateChoice = input.nextInt();
            input.nextLine(); // Consume the newline character

            if (updateChoice == 1) {
                System.out.print("Name: ");
                String name = input.nextLine();
                fileHandling.updateLine(2, name);
            } else if (updateChoice == 2) {
                System.out.print("Password: ");
                String password = input.nextLine();
                fileHandling.updateLine(3, password);
            }

            System.out.println("[1] Return to the Update menu\n[2] Continue");
            System.out.print("Choice: ");
            ch = input.nextInt();
            input.nextLine(); // Consume the newline character
        }
    } else {
        System.out.println(user + " is not found, please try again.");
    }
}
    
    
}
