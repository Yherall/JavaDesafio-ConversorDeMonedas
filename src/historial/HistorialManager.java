package historial;

import monedadivisas.ConversionMonedas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HistorialManager {
    private static final String nombreDocumento = "Historial.txt";

    public static void escribirHistorial(ConversionMonedas consulta){
        try (FileWriter escribirArchivo = new FileWriter(nombreDocumento,true);
             PrintWriter imprimirArchivo = new PrintWriter(escribirArchivo)){
            imprimirArchivo.println(consulta);
        }catch (IOException e){
            System.out.println("Error al Escribir el Archivo: " + e.getMessage());
        }
    }

    public static void mostrarHistorial(){
        try (Scanner lecturaArchivo = new Scanner(new java.io.File(nombreDocumento))){
            if (!lecturaArchivo.hasNextLine()){
                System.out.println("Historial Vacio");
            } else {
                System.out.println("Historial de Conversiones\n");
                while (lecturaArchivo.hasNextLine()){
                    System.out.println(lecturaArchivo.nextLine());
                }
            }
        }catch (IOException e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
