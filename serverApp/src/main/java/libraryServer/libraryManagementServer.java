
package libraryServer;

import ModelClasses.Student;
import java.net.ServerSocket;
import java.io.*;
import static java.lang.System.in;
import java.net.Socket;

/**
 *
 * @author ismaa
 */
public class libraryManagementServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ServerSocket s = null;
         // Register your service on port 5437
        try {
            s = new ServerSocket(54372);
        } 
        catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
            System.exit(0);
        }

        // Run the listen/accept loop forever
        while (true) {
            try {
                // Wait here and listen for a connection
                System.out.println("Server running...listening for a connection...");
                Socket s1 = s.accept();

                // Get output stream associated with the socket
                System.out.println("Connection established"); 
             
                ObjectOutputStream output= new ObjectOutputStream(s1.getOutputStream());
               
                Student a = new Student(123,"James","Madden","6A",true);
                 
              
                output.writeObject(a);
                output.flush();
                
            
                // Close the connection, but not the server socket
                output.close();
                s1.close();
                System.out.println("Connection closed.");
            } 
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
}
