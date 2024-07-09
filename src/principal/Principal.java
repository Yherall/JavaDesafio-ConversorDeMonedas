package principal;

import historial.HistorialManager;
import monedadivisas.ConversionMonedas;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner ingresaOpcion = new Scanner(System.in);
        ArrayList<ConversionMonedas> listaConversion = new ArrayList<>();
        System.out.println("*************************************");
        System.out.println("Bienvenido al conversor de monedas");
        System.out.println("*************************************");

        while (opcion != 9) {
            Menu menu = new Menu();
            menu.objetos();
            menu.menu();
            while (!ingresaOpcion.hasNextInt()) {
                System.out.println("Por favor, ingrese solo números: ");
                ingresaOpcion.nextLine();
            }
            opcion = ingresaOpcion.nextInt();

            switch (opcion) {
                case 1:
                    ConversionMonedas consulta = new ConversionMonedas("", "", 1, "");
                    menu.monedas();
                    consulta.elegirMoneda();
                    consulta.conversionMonedas();
                    listaConversion.add(consulta);
                    HistorialManager.escribirHistorial(consulta);
                    break;

                case 2:
                    HistorialManager.mostrarHistorial();
                    break;

                case 9:
                    menu.finalizar();
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        }
    }
}
