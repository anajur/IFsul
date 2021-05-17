import java.util.LinkedList;

public class Fila {

    private LinkedList<Pedido> fila = new LinkedList<>();

    public void inserirPedido(Pedido p) {
        fila.addLast(p);
    }

    public Pedido entregarPedido() {
        return fila.removeFirst();
    }

    public void verPedidos() {
        System.out.println(fila.toString());
    }

}