public class Vehiculos {
    String placa;
    String marca;
    double cilindraje;
    String tipoCombustible;
    String color;
    String propietario;

    public Vehiculos(String placa, String marca, double cilindraje, String tipoCombustible, String color, String propietario) {
        this.placa = placa;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.tipoCombustible = tipoCombustible;
        this.color = color;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getTipoCombusible() {
        return tipoCombustible;
    }

    public void setTipoCombusible(String tipoCombusible) {
        this.tipoCombustible = tipoCombusible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }


}

