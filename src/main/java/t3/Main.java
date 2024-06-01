package t3;

import t3.logica_expendedor.Comprador;
import t3.logica_expendedor.Expendedor;
import t3.logica_interfaz.LlenarMonedas;

public class Main {
    public static void main(String[] args) {
        Expendedor expendedor = new Expendedor(3);
        Comprador comprador = new Comprador(expendedor);

        LlenarMonedas ventanaMonedas= new LlenarMonedas(comprador);
    }
}