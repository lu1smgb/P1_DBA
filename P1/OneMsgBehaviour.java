/*
 * Practica 1 - Desarrollo Basado en Agentes
 * Luis Miguel Guirado Bautista
 * Universidad de Granada - Curso 2023/2024
 * 
 * Comportamiento volatil que imprime un mensaje por
 * pantalla
 */

package P1;

import jade.core.behaviours.OneShotBehaviour;

public class OneMsgBehaviour extends OneShotBehaviour {

    @Override
    public void action() {
        try {
            System.out.println("Hola mundo!");
            super.myAgent.doDelete();
        }
        catch (Exception e) {
            System.err.println("Algo salió mal");
        }
    }

}
