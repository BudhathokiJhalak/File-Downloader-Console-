/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.filedownloader;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author zak
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try{
        while (true) {
            System.out.println("Enter URL to Download:");
            if (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                URL url = new URL(line);
                URLConnection conn = url.openConnection();
                byte[] data = new byte[1024];
                InputStream is = conn.getInputStream();
                String[] tokens = line.split("/");
                FileOutputStream os = new FileOutputStream(tokens[tokens.length-1]);
                int i = 0;
                while((i=is.read(data))!=-1){
                    os.write(data, 0, i);
                }
                is.close();
                os.close();
            }else{
                System.exit(0);
            }
        }
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

}
