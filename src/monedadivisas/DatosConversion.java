package monedadivisas;

import java.time.LocalDate;

public class DatosConversion {
    private double cantidadCambio;
    private double totalConversion;
    private LocalDate fechaConversion = LocalDate.now();

    public LocalDate getFechaConversion() {
        return fechaConversion;
    }

    public double calculadora (double conversion_rate){
        totalConversion = cantidadCambio * conversion_rate;
        totalConversion = Math.round(totalConversion * 10000.0) / 10000.0;
        return totalConversion;
    }

    public double getCantidadCambio() {
        return cantidadCambio;
    }

    public void setCantidadCambio(double cantidadCambio) {
        this.cantidadCambio = cantidadCambio;
    }

    public double getTotalConversion() {
        return totalConversion;
    }

}
