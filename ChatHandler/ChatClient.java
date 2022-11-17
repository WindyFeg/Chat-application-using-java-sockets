package ChatHandler;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    // private Scanner sc = new Scanner(System.in);

    public void Set(String host, int port) {
        try {
            clientSocket = new Socket(host, port);
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Connected");
            //thread send data
            // Thread sender = new Thread(new Runnable() {
            //     String msg; // will contain data by Sever

            //     @Override // override method
            //     public void run() {
            //         while (true) {
            //             msg = sc.nextLine();
            //             out.println(msg);
            //             out.flush();
            //         }

            //     }
            // });
            // sender.start();

            // //thread receive data
            // Thread receive = new Thread(new Runnable() 
            // {
            //    String msg;
            //    @Override
            //    public void run()
            //    {
            //         try {
            //             msg = in.readLine(); //read data from the client socket
            //             //While client still connect to the sever
            //             while (msg!= null) {
            //                 System.out.println("Sever: " + msg);
            //                 msg = in.readLine(); // repeat
            //             }
    
            //             // if msg null mean client disconnect
            //             System.out.println("Sever out of service");
            //             //close socket and stream
            //             out.close();
            //             clientSocket.close();
                        
            //         } catch (IOException e) {
            //             // TODO: handle exception
            //             e.printStackTrace();
            //         }
            //    }
            // });

            // receive.start();

        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void Send(String uiMsg) {

        // Thread sender = new Thread(new Runnable() {
        String msg; // will contain data by Sever
        // @Override //override method
        // public void run()
        // {
        // while(true)
        // {
        // set message from key board tp msg
        msg = uiMsg; // nextLine will pause exc
        out.println(msg);
        out.flush();
        // }

        // }
        // });

        // sender.start();
    }

    public String receive() {
        String msg;
        try {
            msg = in.readLine(); // read data from the client socket
            // While client still connect to the sever
            if(msg != null) {
                System.out.println("Server: " + msg);
                return "Server: " + msg;
            }

            // if msg null mean client disconnect
            // close socket and stream
            out.close();
            clientSocket.close();
            System.out.println("Client Disconnect");
            
            
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return "Disconnect from sever";

    }

}
