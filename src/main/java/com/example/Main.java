package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        System.out.println("Connected.");
        do{
                String line = in.readLine();  
            if(line == null || line.isEmpty()) {
                break; 
            }
            System.out.println(line);
            String body = "abababababababababababababababba";
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Content-leght:" + body.length());
            out.println();
            out.println(body);
        }while(true); 
    }
}