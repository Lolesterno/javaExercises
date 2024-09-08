package ventas;

public class Order {
    private final int idOrder;
    private Product[] products;
    private int countProducts;
    private static final int MAX_PRODUCTS = 10;
    private static int countOrders;

    public Order() {
        this.idOrder = ++Order.countOrders;
        this.products = new Product[Order.MAX_PRODUCTS];
    }

    public void addProduct(Product producto) {
        if(this.countProducts <= Order.MAX_PRODUCTS) {
            this.products[this.countProducts++] = producto;
        } else
            System.out.println("Se excedio el Nùmero de productos permitidos para agregar: " + Order.MAX_PRODUCTS);
    }

    public double totalOrderPrice(){
        double total = 0;
        for(int i = 0; i < this.countProducts; i++) {
            var product = this.products[i];
            total += product.getPrice();
        }
        return total;
    }

    public void viewOrder() {
        System.out.println("Id Orden: " + this.idOrder);
        var totalOrder = this.totalOrderPrice();
        System.out.println("\tTotal: $" + totalOrder);
        System.out.println("\tProductos: ");
        for(int i = 0; i < this.countProducts; i++) {
            System.out.println("\t\t" + this.products[i]);
        }
    }
}
