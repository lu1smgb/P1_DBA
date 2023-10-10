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

    private ArrayList<Double> numbers = new ArrayList<Double>();

    @Override
    protected void setup() {
        System.out.println("Lanzando agente tipo media aritmética");

        Scanner in = new Scanner(System.in);
        int n_elements = 0;
        while (n_elements <= 0) {
            try {
                System.out.print("Introduce la cantidad de números a leer: ");
                n_elements = in.nextInt();
            }
            catch (InputMismatchException e) {
                System.err.println("La entrada no es valida, intentelo de nuevo");
                if (in.next().isEmpty()) {
                    break;
                }
            }
        }
        
        for (int i = 0; i < n_elements; i++) {
            try {
                System.out.print("Número " + (i + 1) + ": ");
                // ! Usar comas en vez de puntos para la entrada de numeros de coma flotante
                double num = in.nextDouble();
                Behaviour b = new AddNumberToAverage(this, num);
                this.addBehaviour(b);
            }
            catch (InputMismatchException e) {
                System.err.println("La entrada no es valida, intentelo de nuevo");
                i--;
                if (in.next().isEmpty()) {
                    break;
                }
            }
            catch (Exception e) {
                System.err.println("Ha ocurrido un error inesperado");
                doDelete();
            }
        }

        Behaviour b = new CalculateAverageBehaviour(this);
        this.addBehaviour(b);

        in.close();
    }

    public void sumNumber(Double num) {
        numbers.add(num);
    }

    public double calculateAverage() {
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        sum /= numbers.size();
        return sum;
    }

    @Override
    public void takeDown() {
        System.out.println("Terminando agente tipo media aritmética");
        System.exit(0);
    }

}
