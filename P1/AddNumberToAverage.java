/*
 * Practica 1 - Desarrollo Basado en Agentes
 * Luis Miguel Guirado Bautista
 * Universidad de Granada - Curso 2023/2024
 * 
 * Comportamiento usado en el agente tipo media aritmetica para
 * anadir un numero a la lista de numeros del agente
 */

package P1;

import jade.core.behaviours.OneShotBehaviour;

public class AddNumberToAverage extends OneShotBehaviour {

    private AverageAgent agent;
    private Double operand;

    AddNumberToAverage(AverageAgent a, Double num) {
        super(a);
        agent = a;
        operand = num;
    }

    @Override
    public void action() {
        agent.sumNumber(operand);
    }

}