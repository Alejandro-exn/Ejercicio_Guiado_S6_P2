public class Main {

    public static void main(String[] args) {

        Producto prueba = new Producto("P00", "Prueba", 10.00, true);
        System.out.println("=== PRUEBA DE PRODUCTO ===");
        System.out.println("Código: " + prueba.getCodigo());
        System.out.println("Precio: " + prueba.getPrecio());
        System.out.println("Disponible: " + prueba.isDisponible());
        System.out.println();

        Producto[] productos = new Producto[5];
        productos[0] = new Producto("P01", "Mouse", 25.50, true);
        productos[1] = new Producto("P02", "Teclado", 45.00, true);
        productos[2] = new Producto("P03", "Monitor", 180.00, false);
        productos[3] = new Producto("P04", "Audífonos", 35.75, true);
        productos[4] = new Producto("P05", "Webcam", 60.00, false);

        AnalizadorCatalogo analizador = new AnalizadorCatalogo(productos);

        System.out.println("=== CATÁLOGO DE PRODUCTOS ===");
        System.out.println(analizador.listarProductos());


        System.out.println("Disponibles: " + analizador.contarDisponibles());


        System.out.println("Precio promedio: $" + String.format("%.2f", analizador.calcularPrecioPromedio()));
        System.out.println();

        System.out.println("=== BÚSQUEDA ===");
        Producto encontrado = analizador.buscarPorCodigo("P03");
        if (encontrado != null) {
            System.out.println("P03 encontrado: " + encontrado.mostrarInformacion());
        } else {
            System.out.println("P03 no encontrado");
        }

        Producto noExiste = analizador.buscarPorCodigo("P99");
        if (noExiste == null) {
            System.out.println("P99 no encontrado (retornó null)");
        } else {
            System.out.println("P99 encontrado: " + noExiste.mostrarInformacion());
        }
        System.out.println();


        System.out.println("=== DESAFÍO ===");
        Producto masCaro = analizador.obtenerProductoMasCaro();
        if (masCaro != null) {
            System.out.println("Producto más caro: " + masCaro.mostrarInformacion());
        }
        System.out.println();


        AnalizadorCatalogo vacio = new AnalizadorCatalogo(new Producto[0]);
        System.out.println("Promedio con catálogo vacío: " + vacio.calcularPrecioPromedio());
    }
}