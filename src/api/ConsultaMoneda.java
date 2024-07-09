package api;

import com.google.gson.Gson;
import monedadivisas.Moneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public record ConsultaMoneda() {
    public Moneda buscaMoneda(String monedaBase, String monedaCambio) {

        String keyAPI = "b30731984cd77de6e7a8460e";
        String direccion = "https://v6.exchangerate-api.com/v6/" + keyAPI + "/pair/" + monedaBase + "/" + monedaCambio;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class); //CONVIERTE EL CUERPO JSON EN UN OBJETO DE LA CLASE MONEDA USANDO GSON
        } catch (Exception e) {
            throw new RuntimeException("No se Pudo realizar la conversion de divisas");
        }
    }
}
