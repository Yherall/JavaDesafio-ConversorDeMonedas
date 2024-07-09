package monedadivisas;

public record Moneda(
        String base_code,
        String target_code,
        String result,
        double conversion_rate) {

    @Override
    public String result(){
        return result;
    }
}
