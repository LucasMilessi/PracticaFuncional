import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) {
        Factura f=new Factura("ordenador",1000, 12345, 10, new Date(2022,7,12));
        Factura f2=new Factura("movil",300, 45678, 2, new Date(2022,8,21));
        Factura f3=new Factura("impresora",200, 14785, 15, new Date(2022,2,15));
        Factura f4=new Factura("imac",1500, 25896, 8, new Date(2022,12,1));

        List<Factura> lista= new ArrayList<Factura>();

        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);

        Predicate<Factura> predicado = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.out.println("iteracion ");
                return t.getPrecio()>300;
            }
        };

        Predicate<Factura> predicadoCodigo = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getCodigoFactura() == 25896;
            }
        };

        Predicate<Factura> predicadoProductosMayorA = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getCantidadDeProductos() > 8;
            }
        };

        Predicate<Factura> predicadoProductosMenorA = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getCantidadDeProductos() < 8;
            }
        };

        Predicate<Factura> predicadoProductosIgualA = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getCantidadDeProductos() == 10;
            }
        };

        Predicate<Factura> predicadoFechaMayor = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getFechaFactura().after(new Date(2022,3,11));
            }
        };

        Predicate<Factura> predicadoFechaMenor = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getFechaFactura().before(new Date(2022,3,11));
            }
        };

        Factura facturaFiltro= lista.stream()
                .filter(predicado).findFirst().get();
        System.out.println("FACTURA UNICA :"+facturaFiltro.getPrecio() + "\n");

        Factura facturaCodigo = lista.stream()
                .filter(predicadoCodigo).findFirst().get();
        System.out.println("NUMERO DE FACTUR :" + facturaCodigo.getCodigoFactura() + "\n");

        List<Factura> facturaProductoMayorA = lista.stream()
                .filter(predicadoProductosMayorA)
                .collect(Collectors.toList());
        System.out.println("PRODUCTOS MAYOR A 8 : " + facturaProductoMayorA.toString() + "\n");

        List<Factura> facturaProductoMenorA = lista.stream()
                .filter(predicadoProductosMenorA)
                .collect(Collectors.toList());
        System.out.println("PRODUCTOS MENOR A 8 : " + facturaProductoMayorA.toString() + "\n");

        List<Factura> facturaProductoIgualA = lista.stream()
                .filter(predicadoProductosIgualA)
                .collect(Collectors.toList());
        System.out.println("PRODUCTOS QUE TIENEN 10 PRODUCTOS : " +facturaProductoIgualA.toString() + "\n");

        List<Factura> facturaFecha = lista.stream()
                .filter(predicadoFechaMayor)
                .collect(Collectors.toList());
        System.out.println("FECHAS MAYORES A (2022/3/11) : " + facturaFecha.toString() + "\n");

        List<Factura> facturaFechaMenorA = lista.stream()
                .filter(predicadoProductosMenorA)
                .collect(Collectors.toList());
        System.out.println("FECHAS MENORES A (2022/3/11) : " +facturaFechaMenorA.toString());

    }

}
