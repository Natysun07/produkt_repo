public class Main {
    public static void main(String[] args) {
        ShopRepository repo = new ShopRepository();

        try {
            repo.remove(25);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR");
        }
    }
}
