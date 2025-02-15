/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly;

import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class EjemploHilo {
    public static class Hilo extends Thread{
        //public static class Object lock = new Object(); 
        private boolean pausar = false; 
        
        public void pausar(){
            synchronized(this){
                pausar = true;  
            }
        }
        
        public void reaundar(){
            synchronized(this){
                pausar = false;
                this.notify();
            }
        }
        
        

        public void run() {
            for(int i = 0; i <= 10; i++){
                
                
                synchronized(this){ //De esta forma estamos sincronizando con la clase 
                    while(pausar){
                        try{
                            this.wait(); //Se va a parar aquí la ejecución del hilo 
                        }catch(InterruptedException e){
                            Thread.currentThread().interrupt();
                            return ; 
                        }
                    }
                }
                
                System.out.println("Contando "+i);
                try{
                    Thread.sleep(1000); //Esto es puramente estético para que el programa no se ejecute en dos segundos; 
                }catch(InterruptedException e ){
                    Thread.currentThread().interrupt();
                    return; 
                }
                
                
            }
        }
        
        
    }
    
    
    
    public static void main(String[] args) throws InterruptedException{
        
        Hilo h = new Hilo(); 
        h.start();
        Scanner sc =new Scanner(System.in); 
        
        Thread.sleep(3000) ; 
        System.out.println("Pausamos el programa...");
        h.pausar();
        
        //cuentaAtrasPausa();
        
        System.out.print("Dime que tu quiere: ");
        String yo = sc.nextLine(); 
        //Thread.sleep(4000); 
        if(yo.equals("acepto")){
            System.out.println("Reanudando hilo...");
            h.reaundar();
        }
        
        
        
    }
    
    public static void cuentaAtrasPausa() throws InterruptedException{
        for(int i= 10; i > 0 ; i--){
            System.out.println("Cuenta Atras: "+i);
            Thread.sleep(1000); 
        }
    }
}
