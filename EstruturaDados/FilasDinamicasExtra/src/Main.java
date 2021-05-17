import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Produto batataFrita = new Produto(1, "batataFrita", 5.50);
        Produto hamburguer = new Produto(1, "hamburguer", 15.00);

        ItemPedido item1 = new ItemPedido(2, hamburguer);
        ItemPedido item2 = new ItemPedido(1, batataFrita);

        List<ItemPedido> itens1 = new ArrayList<>();
        itens1.add(item1);
        itens1.add(item2);
        List<ItemPedido> itens2 = new ArrayList<>();
        itens2.add(item1);
        List<ItemPedido> itens3 = new ArrayList<>();
        itens3.add(item2);

        Pedido pedido1 = new Pedido(1, LocalDateTime.now(), itens1);
        Pedido pedido2 = new Pedido(2, LocalDateTime.now(), itens2);
        Pedido pedido3 = new Pedido(3, LocalDateTime.now(), itens3);

        Fila fila = new Fila();
        fila.inserirPedido(pedido1);
        fila.inserirPedido(pedido2);
        fila.inserirPedido(pedido3);

        fila.verPedidos();
        System.out.println("Pedido 1 finalizado!");
        fila.entregarPedido();
        fila.verPedidos();


    }

}
