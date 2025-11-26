package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Miothread extends Thread {

    Socket s; 

    public Miothread (Socket s ){
        this.s = s; 
    }

    public void run(){
        BufferedReader in = null;
        PrintWriter out = null;

       try {
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
       } catch (IOException e) {
        
        e.printStackTrace();
       } 
        try {
            out = new PrintWriter(s.getOutputStream(), true);
        } catch (IOException e) {
            
            e.printStackTrace();
        } 
        try {
            String firstline = in.readLine();
            System.out.println(firstline);
            String h; 
            do {
                h = in.readLine();
                System.out.println(h);
            } while (!h.isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
        }


}    
}
