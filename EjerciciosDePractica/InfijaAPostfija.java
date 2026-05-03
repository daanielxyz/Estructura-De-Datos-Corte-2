package EjerciciosDePractica;

import colas.Cola;
import pilas.Pila;

public class InfijaAPostfija {

    // Define prioridad de operadores
    private static int prioridad(String op) {
        switch (op) {
            case "^": return 3;
            case "*":
            case "/": return 2;
            case "+":
            case "-": return 1;
            default:  return 0;
        }
    }

    // Verifica si es operador
    private static boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/") ||
                token.equals("^");
    }

    /**
     * Convierte expresión infija a postfija
     * Ej: (7+8)/(3+2) → 7 8 + 3 2 + /
     * @param infija expresión en notación infija con espacios
     * @return expresión en notación postfija
     */
    public static Cola<String> infijaAPostfija(String infija) {

        // Cola donde va el resultado
        Cola<String> resultado = new Cola<>();
        // Pila para los operadores
        Pila<String> pilaOp = new Pila<>();

        // Separamos la expresión por espacios
        String[] tokens = infija.split(" ");

        for (String token : tokens) {

            if (token.equals("(")) {
                // Paréntesis izquierdo → push directo
                pilaOp.push(token);

            } else if (token.equals(")")) {
                // Paréntesis derecho → vaciar hasta encontrar (
                while (!pilaOp.estaVacia() &&
                        !pilaOp.obtenerCima().equals("(")) {
                    resultado.encolar(pilaOp.pop());
                }
                pilaOp.pop(); // eliminamos el (

            } else if (esOperador(token)) {
                // Operador → desapilar mientras mayor o igual prioridad
                while (!pilaOp.estaVacia() &&
                        !pilaOp.obtenerCima().equals("(") &&
                        prioridad(pilaOp.obtenerCima()) >= prioridad(token)) {
                    resultado.encolar(pilaOp.pop());
                }
                pilaOp.push(token);

            } else {
                // Es un número u operando → va directo a la cola
                resultado.encolar(token);
            }
        }

        // Vaciamos el resto de operadores a la cola
        while (!pilaOp.estaVacia()) {
            resultado.encolar(pilaOp.pop());
        }

        return resultado;
    }

    /**
     * Evalúa una expresión en notación postfija
     * Ej: 7 8 + 3 2 + / → 3
     * @param postfija Cola con la expresión postfija
     * @return resultado de la expresión
     */
    public static double evaluarPostfija(Cola<String> postfija) {

        Pila<Double> pila = new Pila<>();
        Cola<String> clon = postfija.clone();

        while (!clon.estaVacia()) {
            String token = clon.desencolar();

            if (esOperador(token)) {
                // Sacamos dos operandos
                double op2 = pila.pop(); // el último que entró
                double op1 = pila.pop(); // el primero

                double resultado = 0;
                switch (token) {
                    case "+": resultado = op1 + op2; break;
                    case "-": resultado = op1 - op2; break;
                    case "*": resultado = op1 * op2; break;
                    case "/": resultado = op1 / op2; break;
                    case "^": resultado = Math.pow(op1, op2); break;
                }
                pila.push(resultado);

            } else {
                // Es número → push
                pila.push(Double.parseDouble(token));
            }
        }

        return pila.pop();
    }
}