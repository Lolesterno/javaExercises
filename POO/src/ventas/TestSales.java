package ventas;

public class TestSales {
    public static void main(String[] args) {
        System.out.println("*** Sistema de Ventas *** ");

        Product producto1 = new Product("Blusa", 85000);
        Product producto2 = new Product("Zapatos", 250000);
        Product producto3 = new Product("Camiseta", 30000);
        Product producto4 = new Product("Sudadera", 56000);
        Product producto5 = new Product("Gaban", 125000);


        Order orden1 = new Order();
        orden1.addProduct(producto1);
        orden1.addProduct(producto2);
        orden1.addProduct(producto5);
        orden1.viewOrder();

        Order orden2 = new Order();
        orden2.addProduct(producto1);
        orden2.addProduct(producto3);
        orden2.addProduct(producto2);
        orden2.addProduct(producto4);
        orden2.addProduct(producto5);
        orden2.viewOrder();
    }
}
