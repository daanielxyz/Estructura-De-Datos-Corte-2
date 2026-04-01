package Laboratorio26marzo.Ejercicio1;

public class Main {

    public static void main(String[] args) {

        SistemaPanaderia sistema = new SistemaPanaderia();

        sistema.registerClient(new Cliente("Ana"));
        sistema.registerClient(new Cliente("Carlos"));
        sistema.registerClient(new Cliente("María"));
        sistema.registerClient(new Cliente("Luis"));

        System.out.println("=== Current queue ===");
        sistema.showClients();

        System.out.println("\n=== Next client ===");
        sistema.showNextClient();

        System.out.println("\n=== Attending client ===");
        sistema.attendClient();

        System.out.println("\n=== Updated queue ===");
        sistema.showClients();

        System.out.println("\n=== Attending client ===");
        sistema.attendClient();

        System.out.println("\n=== Final queue ===");
        sistema.showClients();
    }
}
