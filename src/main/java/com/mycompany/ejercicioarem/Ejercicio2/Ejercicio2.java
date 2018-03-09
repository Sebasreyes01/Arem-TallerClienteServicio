/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicioarem.Ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author 2117816
 */
public class Ejercicio2 {
    
    public static void main(String[] args) throws MalformedURLException {        
        Scanner readerInput = new Scanner(System.in);
        System.out.println("Enter a URL: ");
        String n = readerInput.nextLine();
        readerInput.close(); 
        URL url = new URL(n);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine = null;
            PrintStream o = new PrintStream(new File("resultado.html"));
            System.setOut(o);
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }        
    }
    
}
