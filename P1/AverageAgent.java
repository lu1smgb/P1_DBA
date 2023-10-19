/*
 * Practica 1 - Desarrollo Basado en Agentes
 * Luis Miguel Guirado Bautista
 * Universidad de Granada - Curso 2023/2024
 * 
 * Agente con una serie de comportamientos para calcular la
 * media aritmetica de numeros proporcionados por el usuario
 */

package P1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class AverageAgent extends Agent {

    private Scanner in = new Scanner(System.in);
    private int n_elements = 0;
    private ArrayList<Double> numbers = new ArrayList<Double>();
    private Double result = 0.0;

    class ReadNumberOfElements extends Behaviour {

        private AverageAgent agent;
        private int n_elements;
        private boolean finished;

        ReadNumberOfElements(AverageAgent a) {
            super(a);
            this.agent = a;
            this.n_elements = 0;
            this.finished = false;
        }

        @Override
        public void action() {
            try {
                System.out.print("Introduce la cantidad de números a leer: ");
                n_elements = in.nextInt();
                finished = n_elements > 0;
                if (finished) {
                    agent.n_elements = n_elements;
                    agent.addBehaviour(new ReadElements(agent));
                }
                else {
                    System.err.println("Numero de elementos invalido, intentelo de nuevo");
                }
            }
            catch (InputMismatchException e) {
                System.err.println("Formato de la entrada no valido, intentelo de nuevo");
                in.next();
            }
            catch (Exception e) {
                System.out.println("Error en " + this.getClass().getName());
            }
        }

        @Override
        public boolean done() {
            return finished;
        }
    }

    class ReadElements extends Behaviour {

        private AverageAgent agent;
        private int stored_elements;
        private boolean finished = false;

        ReadElements(AverageAgent a) {
            super(a);
            this.agent = a;
            this.stored_elements = 0;
            this.finished = false;
        }

        @Override
        public void action() {
            try {
                System.out.print("Introduce el numero " + (stored_elements + 1) + ": ");
                Double element = in.nextDouble();
                agent.numbers.add(element);
                stored_elements++;
                finished = stored_elements == agent.n_elements;
                if (finished) {
                    agent.addBehaviour(new CalculateAverage(agent));
                }
            }
            catch (InputMismatchException e) {
                System.err.println("Formato de la entrada no valido, intentelo de nuevo");
                in.next();
            }
            catch (Exception e) {
                System.err.println("Ha ocurrido un error inesperado: " + e.getClass().getName());
            }
        }

        @Override
        public boolean done() {
            return finished;
        }

    }

    class CalculateAverage extends Behaviour {

        private AverageAgent agent;
        private Double sum;
        private int added_elements;
        private boolean finished;

        CalculateAverage(AverageAgent a) {
            super(a);
            this.agent = a;
            this.sum = 0.0;
            this.added_elements = 0;
            this.finished = false;
        }

        @Override
        public void action() {
            try {
                sum += agent.numbers.get(added_elements);
                added_elements++;
                finished = added_elements == agent.n_elements;
                if (finished) {
                    agent.result = sum / agent.n_elements;
                    System.out.println("Resultado: " + agent.result);
                    doDelete();
                }
            }
            catch (Exception e) {
                System.out.println("Error en " + this.getClass().getName());
            }
        }

        @Override
        public boolean done() {
            return finished;
        }

    }

    @Override
    protected void setup() {
        // Inicializaremos el resto de comportamientos a partir del primero de
        // forma secuencial, es decir, arrancaremos el segundo a partir del primero
        // y el tercero a partir del segundo
        // 1 -> 2 -> 3
        System.out.println("Lanzando agente tipo media aritmética");
        this.addBehaviour(new ReadNumberOfElements(this));
        //// this.addBehaviour(new ReadElements(this));
        //// this.addBehaviour(new CalculateAverage(this));
    }

    @Override
    public void takeDown() {
        System.out.println("Terminando agente tipo media aritmética");
        in.close();
        System.exit(0);
    }

}
