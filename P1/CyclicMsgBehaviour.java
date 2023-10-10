/*
 * Practica 1 - Desarrollo Basado en Agentes
 * Luis Miguel Guirado Bautista
 * Universidad de Granada - Curso 2023/2024
 * 
 * Comportamiento ciclico que imprime un mensaje por pantalla
 * cada cierto tiempo
 */

package P1;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class CyclicMsgBehaviour extends TickerBehaviour {

    private String msg;

    CyclicMsgBehaviour(Agent a, String msg, int ms) {
        super(a, ms);
    }
    
    @Override
    protected void onTick() {
        System.out.println(msg);
    }

}
