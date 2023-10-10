/*
 * Practica 1 - Desarrollo Basado en Agentes
 * Luis Miguel Guirado Bautista
 * Universidad de Granada - Curso 2023/2024
 * 
 * Ejercicio 1
 * 
 * Agente que imprime un mensaje por pantalla y despues termina
 */

package P1;

import jade.core.Agent;

public class BasicMsgAgent extends Agent {
    
    @Override
    protected void setup() {
        System.out.println("Lanzando agente tipo mensaje basico");
        System.out.println("Hola mundo!");
        doDelete();
    }

    @Override
    public void takeDown() {
        System.out.println("Terminando agente tipo mensaje basico");
        System.exit(0);
    }
}
