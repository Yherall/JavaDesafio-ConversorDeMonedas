package monedadivisas;

import api.ConsultaMoneda;

import java.io.IOException;
import java.util.Scanner;

public class ConversionMonedas {
    private String monedaBase;
    private String monedaCambio;
    private int cantidadUsuario;
    private String total;
    private String error = "Error";

    public ConversionMonedas(String monedaBase, String monedaCambio, int cantidadUsuario, String total){
        this.monedaBase = monedaBase;
        this.monedaCambio = monedaCambio;
        this.cantidadUsuario = cantidadUsuario;
        this.total = total;
    }

    Scanner lecctura = new Scanner(System.in);
    ConsultaMoneda consultaMoneda = new ConsultaMoneda();
    DatosConversion datosConversion = new DatosConversion();

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public void setMonedaCambio(String monedaCambio) {
        this.monedaCambio = monedaCambio;
    }

    public void setCantidadUsuario(int cantidadUsuario) {
        this.cantidadUsuario = cantidadUsuario;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void elegirMoneda(){
        System.out.println("Ingrese siglas de la Moneda que va a comparar");
        setMonedaBase(lecctura.nextLine().toUpperCase());

        System.out.println("Ingrese siglas de la Moneda que sera comparada");
        setMonedaCambio(lecctura.nextLine().toUpperCase());

        System.out.println("Ingrese la cantidad que desea cambiar");
        while (!lecctura.hasNextInt()){ // SI VALOR DE USUARIO ES DIFERENTE DE UN VALOR ENTERO, PEDIRA NUEVAMENTE INGRESAR UN VALOR ENTERO
            System.out.println("Solo se admiten numeros");
            System.out.println("Indique Cantidad: ");
            lecctura.nextLine();
        }
        setCantidadUsuario(lecctura.nextInt());
        datosConversion.setCantidadCambio(cantidadUsuario);
    }

    public void conversionMonedas(){

        Moneda moneda = consultaMoneda.buscaMoneda(monedaBase, monedaCambio);
        if (moneda.result().equals(error)){
            System.out.println("Codigo Erroneo, intente nuevamente");
        }else {
            datosConversion.calculadora(moneda.conversion_rate());
            System.out.println("******************************************");
            setTotal("$"+datosConversion.getCantidadCambio() + " " + monedaBase + " Equivale a: " + "$" + datosConversion.getTotalConversion() + " " + monedaCambio);
            System.out.println(total);
            System.out.println("Fecha de Conversion: " + datosConversion.getFechaConversion());
            System.out.println("******************************************\n");
        }
    }

    @Override
    public String toString(){
        return "Historial De Conversiones" +
                "*************************************\n" +
                "Moneda Base: " + monedaBase + "\n" +
                "Moneda a Cambiar: " + monedaCambio + "\n" +
                "Cantidad: " + cantidadUsuario + "\n" +
                "Total: " + total + "\n";
    }

}
