import java.util.Date;

public class Factura {
    String descripcion;
    int precio;
    int codigoFactura;
    int cantidadDeProductos;
    Date fechaFactura;

    Factura(String descripcion, int precio, int codigoFactura, int cantidadDeProductos, Date fechaFactura) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.codigoFactura = codigoFactura;
        this.cantidadDeProductos = cantidadDeProductos;
        this.fechaFactura = fechaFactura;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    @Override
    public String toString() {
        return "\nFactura{" +
                "descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", codigoFactura=" + codigoFactura +
                ", cantidadDeProductos=" + cantidadDeProductos +
                ", fechaFactura=" + fechaFactura +
                '}';
    }
}
