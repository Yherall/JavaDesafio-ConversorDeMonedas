package principal;

import monedadivisas.ConversionMonedas;

public class Menu {

    public void objetos(){
        ConversionMonedas consulta = new ConversionMonedas("","", 1,"");
    }

    public void monedas(){
        System.out.println("""
                Monedas Para Convertir:
                
                1.- ARS - Peso Argentino
                2.- BOB - Boliviano Bolivia
                3.- BRL - Real brasileño
                4.- CLP - Peso chileno
                5.- COP - Peso colombiano
                6.- USD - Dólar estadounidense
                """);
        System.out.println("************************************");
    }

    public void menu(){
        System.out.println("""
                Menu Principal:
                
                1-Convertir Moneda
                2-Historial de Conversiones
                9-Salir
                """);
        System.out.println("**************************************");
    }

    public void finalizar(){
        System.out.println("**************************************");
        System.out.println("Proceso Terminado");
        System.out.println("Agradecemos el uso de la Aplicacion");
        System.out.println("**************************************");
    }
}
