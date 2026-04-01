package Laboratorio26marzo.Ejercicio1;

public class SistemaPanaderia {

    SimpleList<Cliente> listClient= new SimpleList<>();


    public SistemaPanaderia() {}

    public SimpleList getListClient() {
        return listClient;
    }

    public void setListClient(SimpleList<Cliente> listClient) {
        this.listClient = listClient;
    }

    public void registerClient(Cliente client) {
        listClient.addLast(client);
    }

    public void attendClient() {
        Object cliente = listClient.getFirstNode().getNodeValue();
        System.out.println("Atendiendo primer cliente" + cliente.toString());
        listClient.removeFirst();
    }

    public void showNextClient(){
        Object cliente = listClient.getFirstNode().getNodeValue();
        System.out.println("El siguiente cliente es: " + cliente.toString());
    }

    public void showClients(){
        for(Object t:listClient){
            System.out.println(t.toString());
        }
    }

}
