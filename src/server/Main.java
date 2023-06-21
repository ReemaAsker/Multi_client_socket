package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //using serversocket as argument to automatically close the socket

        //list to add all the clients thread
        ArrayList<Server> threadList = new ArrayList<>();
        try (ServerSocket serversocket = new ServerSocket(6666)){
            while(true) {
                Socket socket = serversocket.accept();
                Server serverThread = new Server(socket, threadList);
                //starting the thread
                threadList.add(serverThread); 
                serverThread.start();

                //get all the list of currently running thread

            }
        } catch (Exception e) {
            System.out.println("Error occured in main: " + e.getMessage());
        }
    }
}