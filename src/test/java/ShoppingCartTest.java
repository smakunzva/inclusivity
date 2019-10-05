import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private Product product;
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() throws ParseException {
        shoppingCart = new ShoppingCart();

        addCartProducts(1, "Dove soap", 39.99);

        addCartProducts(2, "Dove soap", 39.99);

        addCartProducts(3, "Dove soap", 39.99);

        addCartProducts(4, "Dove soap", 39.99);

        addCartProducts(5, "Dove soap", 39.99);
    }

    private void addCartProducts(int id, String name, double price) throws ParseException {
        product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        shoppingCart.addProduct(product);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addProduct() throws ParseException {
        Assertions.assertEquals(5, shoppingCart.getProducts().size());
    }

    @Test
    void getProducts() throws ParseException {

        Assertions.assertEquals(3, ((Product)shoppingCart.getProducts().get(2)).getId());
        Assertions.assertEquals("Dove soap", ((Product)shoppingCart.getProducts().get(0)).getName());

        Iterator iterator = shoppingCart.getProducts().iterator();

        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            Assertions.assertEquals(39.99, product.getPrice());
        }
    }

    @Test
    void getTotalPrice() throws ParseException {
        Assertions.assertEquals(199.95, shoppingCart.getTotalPrice());
    }
}