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
            String path = firstline.split(" ")[1];
            if (path.equals("/Michele")){
            System.out.println("la tua richiesta è terminata, ora ti rispondo");
            String body = "<html><body><h1>Michele oggi ha il capo cecio</h1></body></html>";
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Server: Cecio");
            out.println("Content-Length:" + body.length());
            out.println("");
            out.println(body);
            } 
            else if (path.equals("/Abati")){
                System.out.println("la tua richiesta è terminata, ora ti rispondo");
                String body = "<html><body><h1>Abati oggi sta perdendo i capelli</h1></body></html>";
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println("Server: Cecio");
                out.println("Content-Length:" + body.length());
                out.println("");
                out.println(body);
            }else if (path.equals("/Betti")){
                System.out.println("la tua richiesta è terminata, ora ti rispondo");
                String body = "<html><body><h1>Matteo è una favola</h1></body></html>";
                out.println("HTTP/1.1 301 Moved Permanently");
                redirected: out.println("Location: /Michele");
                out.println("Content-Type: text/html");
                out.println("Server: Cecio");
                out.println("Content-Length:" + body.length());
                out.println("");
                out.println(body);
            }else {
                out.println("HTTP/1.1 404 Not Found");
                out.println("Content-Type: text/html");
                out.println("Server: Cecio");
                out.println("");
                out.println("pagina non trovata");
            }
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
