/*
 * Practica 1 - Desarrollo Basado en Agentes
 * Luis Miguel Guirado Bautista
 * Universidad de Granada - Curso 2023/2024
 * 
 * Comportamiento usado en el agente tipo media aritmetica para
 * calcular la media de los numeros de la lista del agente
 */

package P1;

import jade.core.behaviours.OneShotBehaviour;

public class CalculateAverageBehaviour extends OneShotBehaviour {
    
    private AverageAgent agent;

    CalculateAverageBehaviour(AverageAgent a) {
        super(a);
        agent = a;
    }

    @Override
    public void action() {
        double resultado = agent.calculateAverage();
        System.out.println("Resultado: " + resultado);
        agent.doDelete();
    }

}
