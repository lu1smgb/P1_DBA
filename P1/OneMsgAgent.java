/*
 * Practica 1 - Desarrollo Basado en Agentes
 * Luis Miguel Guirado Bautista
 * Universidad de Granada - Curso 2023/2024
 * 
 * Implementacion del agente con
 * comportamiento OneMsgBehaviour (tipo OneShot)
 */

package P1;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class OneMsgAgent extends Agent {
    
    @Override
    protected void setup() {
        System.out.println("Lanzando agente tipo one shot");
        Behaviour b = new OneMsgBehaviour();
        this.addBehaviour(b);
    }
    
    @Override
    public void takeDown() {
        System.out.println("Terminando agente tipo one shot");
        System.exit(0);
    }
    
}
