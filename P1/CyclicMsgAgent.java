/*
 * Practica 1 - Desarrollo Basado en Agentes
 * Luis Miguel Guirado Bautista
 * Universidad de Granada - Curso 2023/2024
 * 
 * Agente con comportamiento CyclicMsgBehaviour
 */

package P1;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class CyclicMsgAgent extends Agent {
    
    @Override
    protected void setup() {
        System.out.println("Lanzando agente tipo ciclico");
        Behaviour b = new CyclicMsgBehaviour(this, "Mensaje ciclico", 2000);
        this.addBehaviour(b);
    }
    
    @Override
    public void takeDown() {
        System.out.println("Terminando agente tipo ciclico");
        System.exit(0);
    }
    
}
