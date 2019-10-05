import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List products = new ArrayList<Product>();
    private double totalPrice;
    private double taxTotal;
    private  double tax;

    public void addProduct(Product product) throws ParseException {
        this.products.add(product);
        this.tax = product.getPrice() * (Tax.TAX_RATE.getTaxRate() / 100);
        this.taxTotal += this.tax;
        this.totalPrice += product.getPrice() + this.tax;
        this.totalPrice = decimalFormat(this.totalPrice);
    }

    public List getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private double decimalFormat(Double value) throws ParseException {
        DecimalFormat df = new DecimalFormat("##.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        NumberFormat nf = NumberFormat.getInstance();
        return nf.parse(df.format(value)).doubleValue();
    }

    public double getTaxTotal() throws ParseException {
        return decimalFormat(taxTotal);
    }

}
