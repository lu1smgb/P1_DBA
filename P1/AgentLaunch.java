/*
 * Practica 1 - Desarrollo Basado en Agentes
 * Luis Miguel Guirado Bautista
 * Universidad de Granada - Curso 2023/2024
 * 
 * Programa que lanza un agente determinado a partir de
 * su nombre de clase canonico (agentClassName)
 */

package P1;

import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class AgentLaunch {
    public static void main(String[] args) {
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "172.19.0.1");
        p.setParameter(Profile.CONTAINER_NAME, "Mi contenedor");
        ContainerController cc = rt.createAgentContainer(p);
        String agentClassName = AverageAgent.class.getCanonicalName();
        System.out.println(agentClassName);
        try {
            AgentController ac = cc.createNewAgent("Luis", agentClassName, null);
            ac.start();
        }
        catch (StaleProxyException e) {
            System.err.println("Error al crear el agente: StaleProxyException");
        }

    }
}
