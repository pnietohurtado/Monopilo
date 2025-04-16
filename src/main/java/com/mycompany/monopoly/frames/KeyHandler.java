/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monopoly.frames;

import com.mycompany.monopoly.frames.Jugador2.MenuPanelP2;
import com.mycompany.monopoly.frames.JugadorUno.MenuPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class KeyHandler implements KeyListener{

    Scanner sc = new Scanner(System.in); // Me sirve para poder leer el inicio de sesión al principio del usuario.
    public boolean upPressed, downPressed, leftPressed, rightPressed, showCollisions, drawTime;
    public boolean showFPS; 
    public boolean catchObject; 
    public boolean menu; 
    
    
    
    public GamePanel gp; 
    
    public KeyHandler(GamePanel gp){
        this.gp = gp; 
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode(); 
        
        if(gp.gameState == gp.dialogueState){
            if(code == KeyEvent.VK_ENTER){
                gp.gameState = gp.playState; 
            }
        }
        
        if(code == KeyEvent.VK_W)
        {
            this.upPressed = true; 
        }
        if(code == KeyEvent.VK_S)
        {
            this.downPressed = true; 
        }
        if(code == KeyEvent.VK_A)
        {
            this.leftPressed = true; 
            /* 
            if(code == KeyEvent.VK_SHIFT){
                System.out.println("FIUMMMMMM");
                gp.player.speed = 17; 
            }
            */
        }
        if(code == KeyEvent.VK_D)
        {
            this.rightPressed = true; 
        }if(code == KeyEvent.VK_K)
        {
            if(showCollisions == false){
                this.showCollisions = true; 
            }else if(showCollisions == true){
                this.showCollisions = false; 
            }
        }
        if(code == KeyEvent.VK_ESCAPE) // In order to pause the game
        {
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState; 
            }else if(gp.gameState == gp.pauseState){
                gp.gameState = gp.playState; 
            }
        }
        
        
        if(code  == KeyEvent.VK_T)
        {
            if(drawTime == false){
                drawTime = true; 
            }else if(drawTime == true){
                drawTime = false; 
            }
        }
        
        if(code  == KeyEvent.VK_P)
        {
            if(showFPS == false){
                showFPS = true; 
            }else if(showFPS == true){
                showFPS = false; 
            }
        }
        
        if(code == KeyEvent.VK_E){ // Coger un objeto del suelo
            this.catchObject = true; 
        }
        
        // Para entrar al menu de juego
        if(code == KeyEvent.VK_CONTROL){
            gp.gameState = gp.titleState; 
        }
        
        // Menu de juego
        
        if(gp.gameState == gp.ingameState){
            if(gp.ui.ingameScreenState == 0){
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
                {
                    gp.ui.commandNumber--; 
                    if(gp.ui.commandNumber < 0){
                        gp.ui.commandNumber = 5; 
                    }
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
                {
                    gp.ui.commandNumber++; 
                    if(gp.ui.commandNumber > 5){
                        gp.ui.commandNumber = 0; 
                    }

                }
                
                if(code == KeyEvent.VK_ENTER){
                    if(gp.ui.commandNumber == 0){ // Tirar el dado 
                        
                        
                        gp.confirmar =  true; 
                        
                        gp.volverJuego();  // Vuelve al juego 
                        gp.gameState = gp.dialogueState; // Va a aparecer la ventana de dialogo 
                        gp.menuSelection = 1;  // En forma de ayuda para poder identificar la opción seleccionada
                        
                    }else if(gp.ui.commandNumber == 1){
                        gp.gameState = gp.playState; 
                    }else if(gp.ui.commandNumber == 2){
                        System.exit(0); 
                    }
                }
                
                
            }
        }
        
        // Mostrar el menu de juego 
        if(code == KeyEvent.VK_I){
            if(menu == false){
                menu = true; 
            }else if(menu == true){
                menu = false; 
            }
        }
        
        
        // Titulo
        
        if(gp.gameState == gp.titleState){
            if(gp.ui.titleScreenState == 0){

                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
                {
                    gp.ui.commandNumber--; 
                    if(gp.ui.commandNumber < 0){
                        gp.ui.commandNumber = 2; 
                    }
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
                {
                    gp.ui.commandNumber++; 
                    if(gp.ui.commandNumber > 2){
                        gp.ui.commandNumber = 0; 
                    }

                }

                if(code == KeyEvent.VK_ENTER){
                    if(gp.ui.commandNumber == 0){
                        gp.ui.titleScreenState = 1; 
                    }else if(gp.ui.commandNumber == 1){
                        gp.gameState = gp.playState; 
                    }else if(gp.ui.commandNumber == 2){
                        System.exit(0); 
                    }
                }
            }else if(gp.ui.titleScreenState == 1){ // Pantalla de (Inicio de Sesión, Registrarse, Go Back) 
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
                {
                    gp.ui.commandNumber--; 
                    if(gp.ui.commandNumber < 0){
                        gp.ui.commandNumber = 2; 
                    }
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
                {
                    gp.ui.commandNumber++; 
                    if(gp.ui.commandNumber > 2){
                        gp.ui.commandNumber = 0; 
                    }

                }

                if(code == KeyEvent.VK_ENTER){
                    if(gp.ui.commandNumber == 0){
                        
                        gp.ui.titleScreenState = 2; 
                    }else if(gp.ui.commandNumber == 1){
                        gp.ui.titleScreenState = 3;  
                    }else if(gp.ui.commandNumber == 2){
                        gp.ui.titleScreenState = 0; 
                    }
                }
                
                
                
            }else if(gp.ui.titleScreenState == 2){ // Pantalla de inicio de Sesión 
                if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
                {
                    gp.ui.commandNumber--; 
                    if(gp.ui.commandNumber < 0){
                        gp.ui.commandNumber = 2; 
                    }
                }
                if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
                {
                    gp.ui.commandNumber++; 
                    if(gp.ui.commandNumber > 2){
                        gp.ui.commandNumber = 0; 
                    }

                }

                if(code == KeyEvent.VK_ENTER)
                    /*En el caso de que se encuentre en la sección de "Inicio de sesión" vamos a tener que introducir el usuario 
                    el cual vamos a pasar luego al MenuPanel*/
                {
                    if(gp.ui.commandNumber == 0) {
                        
                        System.out.print("Dime tu nombre: ");
                        gp.playerName = JOptionPane.showInputDialog(null, "Introduce tu usuario", gp.playerName);
                        System.out.println(gp.playerName);
                        
                    }else if(gp.ui.commandNumber == 1){
                        
                        System.out.print("Dime tu pass: ");
                        gp.playerPass = JOptionPane.showInputDialog(null, "Introduce tu contraseña", gp.playerPass);
                        System.out.println(gp.playerPass);
                        
                        gp.gameState = gp.playState; 
                    }else if(gp.ui.commandNumber == 2){
                        gp.ui.commandNumber = 0; 
                        gp.ui.titleScreenState = 1; 
                    }
                }
                    
                
                
                
                }else if( gp.ui.titleScreenState == 3){ // Pantalla de registro 
                        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
                    {
                        gp.ui.commandNumber--; 
                        if(gp.ui.commandNumber < 0){
                            gp.ui.commandNumber = 5; 
                        }
                    }
                    if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
                    {
                        gp.ui.commandNumber++; 
                        if(gp.ui.commandNumber > 5){
                            gp.ui.commandNumber = 0; 
                        }

                    }
                    
                    if(code == KeyEvent.VK_ENTER)
                    
                    {
                    if(gp.ui.commandNumber == 0) {
                        
                        System.out.print("Dime tu nombre: ");
                        gp.playerNombre = JOptionPane.showInputDialog(null, "Introduce tu usuario", gp.playerNombre);
                        System.out.println(gp.playerNombre);
                        
                    }else if(gp.ui.commandNumber == 1){
                        
                        System.out.print("Dime tu apellido: ");
                        gp.playerApellido = JOptionPane.showInputDialog(null, "Introduce tu contraseña", gp.playerApellido);
                        System.out.println( gp.playerApellido);
                        
                    }else if(gp.ui.commandNumber == 2){
                        
                        System.out.print("Dime tu user: ");
                        gp.playerName = JOptionPane.showInputDialog(null, "Introduce tu usuario", gp.playerName);
                        System.out.println(gp.playerName);
                        
                    }else if(gp.ui.commandNumber == 3){
                        
                        System.out.print("Dime tu pass: ");
                        gp.playerPass = JOptionPane.showInputDialog(null, "Introduce tu contraseña", gp.playerPass);
                        System.out.println(gp.playerPass);
                        
                        
                    }else if(gp.ui.commandNumber == 4){
                        gp.confirmar = true; 
                        if(gp.jugador == 1){
                            MenuPanel mp = new MenuPanel(gp); 
                            mp.startMenuThread();
                        }else if(gp.jugador == 2){
                            MenuPanelP2 mp = new MenuPanelP2(gp); 
                            mp.startMenuThread();
                        }
                        
                        gp.gameState = gp.playState; 
                    
                    }else if(gp.ui.commandNumber == 5){
                        gp.ui.titleScreenState = 1; 
                    }
                    
                    
                    }
                    
                    
                    
            }
        }
        
    }
    
    /*
    public void ordenarTurno(){
        confirmar = true; 
    }
    */
    
    

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode(); 
        
        
        if(code == KeyEvent.VK_W)
        {
            this.upPressed = false; 
        }
        if(code == KeyEvent.VK_S)
        {
            this.downPressed = false; 
        }
        if(code == KeyEvent.VK_A)
        {
            this.leftPressed = false; 
        }
        if(code == KeyEvent.VK_D)
        {
            this.rightPressed = false; 
        }
        if(code == KeyEvent.VK_E){
            this.catchObject = false; 
        }
    }
    
    
    
}
