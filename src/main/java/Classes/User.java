
package Classes;
import java.util.Scanner;


public abstract class User{
    
private static int count;
private final String id;
private String name;
private String email;
private String password;
//FileHandling user;
//Scanner input;

public User(String user, int count)
{
    User.count++;
   this.id = user + count; 
   
}
 
public String getId() {
    return this.id;
 //return user.readLine(1);
}

public String getName() {
    return this.name;
    //return user.readLine(2);
}

public void setName(String name) {
this.name = name;
//user.appendLine(2, this.name);
}

public String getEmail() {
    return this.email;
    // return user.readLine(3);
}

public void setEmail(String email) {
this.email = email;
//user.appendLine(3, this.email);
}

public String getPassword() {
    return this.password;
     //return user.readLine(4);
}

public void setPassword(String password) {
this.password = password;
//user.appendLine(4, this.password);
}

 public boolean login(String path)
 {
     Scanner input = new Scanner(System.in);
     System.out.println("[Please enter you verification information]");
     System.out.print("ID: "); 
        String uid = input.nextLine();
     System.out.print("E-mail: "); 
        String uemail = input.nextLine();
     System.out.print("Password: "); 
        String upassword = input.nextLine();
        FileHandling fileCheckAccount =new FileHandling(path+uid+".txt");
        if(fileCheckAccount.checkFileExistence()){
            String userEmail = fileCheckAccount.readLine(3);
            String userPassword = fileCheckAccount.readLine(4);


            if(uemail.equals(userEmail) && upassword.equals(userPassword)){
            System.out.println("login successful");
                return true;
            } else {
            System.out.println("invalid email or password, try again!");
                return false;
                }
            }
        else
            return false;
        
    }
 

       

}
