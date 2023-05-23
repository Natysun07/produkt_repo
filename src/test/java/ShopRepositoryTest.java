import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(1, "книга 1", 1);
    Product product2 = new Product(2, "книга 2", 2);
    Product product3 = new Product(3, "книга 3", 3);
    Product product4 = new Product(4, "книга 4", 4);
    Product product5 = new Product(5, "книга 5", 5);
    Product product6 = new Product(6, "книга 6", 6);

    @BeforeEach
    public void setup() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
        repo.add(product6);
    }


    @Test
    public void NotFoundExceptionTest() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(10);
        });
    }

    @Test
    public void SuccessfulRemovingTest() {
        repo.remove(3);
        Product[] expected = {product1, product2, product4, product5, product6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewProduct() {
        Product product7 = new Product(7, "книга 7", 7);
        repo.add(product7);
        Product[] expected = {product1, product2, product3, product4, product5, product6, product7};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddExistID() {
        Product product8 = new Product(5, "книга 8", 8);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product8);
        });
    }

}
