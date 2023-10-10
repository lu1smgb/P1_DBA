/*
 * Practica 1 - Desarrollo Basado en Agentes
 * Luis Miguel Guirado Bautista
 * Universidad de Granada - Curso 2023/2024
 * 
 * Agente que imprime informacion basica del
 * mismo por pantalla
 */

package P1;

import jade.core.Agent;
import java.util.Iterator;

public class BasicHelloWorld extends Agent {

    @Override
    protected void setup() {
        
        System.out.println("Hola! Soy tu primer agente");
        
        System.out.println("Nombre local: " + getAID().getLocalName());
        System.out.println("GUID: " + getAID().getName());
        System.out.println("Lista de direcciones:");
        Iterator it = getAID().getAllAddresses();
        while (it.hasNext()) {
            System.out.println("- " + it.next());
        }
        
        doDelete();
        
    }
    
    @Override
    public void takeDown() {
        System.out.println("Terminando agente...");
    }
}