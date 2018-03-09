/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicioarem.Ejercicio1;

import java.net.URL;

/**
 *
 * @author 2117816
 */
public class Ejercicio1 {
    
    public static void main(String[] args) throws Exception {
        URL google = new URL("https://www.google.com:80/search?q=AE&dcr=0&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjO8IOX3bzZAhVJulMKHXYmAB4Q_AUICigB&biw=1920&bih=974#imgrc=5BoPHHsCue8o6M:");
        System.out.println(google.getProtocol());
        System.out.println(google.getAuthority());
        System.out.println(google.getHost());
        System.out.println(google.getPort());
        System.out.println(google.getPath());
        System.out.println(google.getQuery());
        System.out.println(google.getFile());
        System.out.println(google.getRef());
    }
    
}
