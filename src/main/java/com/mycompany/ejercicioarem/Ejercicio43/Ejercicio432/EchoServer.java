package com.mycompany.ejercicioarem.Ejercicio43.Ejercicio432;

import java.net.*;
import java.io.*;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine = null;
        String outputLine = null;
        String operation = "cos";
        Double input = null;
        Double answer = null;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje: " + inputLine);
            try {
                input = Double.parseDouble(inputLine);
                switch (operation) {
                    case "sin":
                        answer = Math.sin(input);
                        break;
                    case "cos":
                        answer = Math.cos(input);
                        break;
                    case "tan":
                        answer = Math.tan(input);
                        break;
                }
                outputLine = "Respuesta: " + answer;
                out.println(outputLine);
            } catch (NumberFormatException e) {
                if(inputLine.startsWith("fun:")) {
                    if(inputLine.substring(4).equals("sin") || inputLine.substring(4).equals("cos") || inputLine.substring(4).equals("tan")) {
                        operation = inputLine.substring(4);
                        out.println("Operation changed to: " + operation);
                    } else {
                        out.println("The operation is invalid, try again");
                    }
                } else {
                    if (outputLine.equals("Respuesta: Bye.")) {
                        break;
                    }
                    out.println("The input is invalid, try again");
                }
            }

        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
