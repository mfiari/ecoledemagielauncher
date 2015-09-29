/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfiari.ecoledemagie.launcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mike
 */
public class Main {
    
    public static void main (String args[]) {
        try {
            Runtime rt = Runtime.getRuntime();
            //Process pr = rt.exec("java -jar exe/EcoleDeMagieGame.jar debug launcher");
            //Process pr = rt.exec("cmd /c dir exe");
            //Process pr = rt.exec("cmd /c java -jar exe/EcoleDeMagieGame.jar");
            Process pr = rt.exec("java -cp exe/EcoleDeMagieGame.jar mfiari.ecoledemagie.game.jeu");
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while((line=input.readLine()) != null) {
                System.out.println(line);
            }
            int exitVal = pr.waitFor();
            System.out.println("Exited with error code "+exitVal);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
