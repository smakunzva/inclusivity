import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List products = new ArrayList<Product>();
    private double totalPrice;

    public void addProduct(Product product) throws ParseException {
        this.products.add(product);
        this.totalPrice = decimalFormat(this.totalPrice + product.getPrice());
    }

    public List getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private double decimalFormat(Double value) throws ParseException {
        DecimalFormat df = new DecimalFormat("##.00");
        NumberFormat nf = NumberFormat.getInstance();
        return nf.parse(df.format(value)).doubleValue();
    }

}
