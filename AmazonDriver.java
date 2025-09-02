import java.util.*;

class Products {
    int prodId;
    String prodType;
    String prodName;
    double prodPrice;

    static List<Products> prodList = new ArrayList<>();
    static List<Products> cartProd = new ArrayList<>();

    public Products(int prodId, String prodType, String prodName, double prodPrice) {
        this.prodId = prodId;
        this.prodType = prodType;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    public static void addProduct(Scanner sc) {
        System.out.println("Add Product ........................");
        System.out.print("Enter product id: ");
        int prodId = sc.nextInt();
        System.out.print("Enter Product Type (Mobile/Fashion/Book): ");
        String prodType = sc.next();
        System.out.print("Enter Product Name: ");
        String prodName = sc.next();
        System.out.print("Enter Price: ");
        double prodPrice = sc.nextDouble();

        prodList.add(new Products(prodId, prodType, prodName, prodPrice));
        System.out.println("Product added successfully!");
    }

    public static void dispProducts(Scanner sc) {
        if (prodList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("Available Products:");
        for (int i = 0; i < prodList.size(); i++) {
            Products p = prodList.get(i);
            System.out.println((i + 1) + ". " + p.prodId + " | " + p.prodType + " | " + p.prodName + " | ₹" + p.prodPrice);
        }

        System.out.print("Do you want to add a product to cart (y/n): ");
        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            System.out.print("Enter product number to add: ");
            int choice = sc.nextInt();
            if (choice >= 1 && choice <= prodList.size()) {
                cartProd.add(prodList.get(choice - 1));
                System.out.println("Product added to cart!");
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public static void cart() {
        if (cartProd.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your Cart:");
            for (Products p : cartProd) {
                System.out.println(p.prodId + " | " + p.prodType + " | " + p.prodName + " | Rs." + p.prodPrice);
            }
        }
    }

    public static void checkout() {
        if (cartProd.isEmpty()) {
            System.out.println("Cart is empty. Add items before checkout.");
        } else {
            double total = 0;
            for (Products p : cartProd) {
                total += p.prodPrice;
            }
            System.out.println("Checkout successful! Total bill = Rs." + total);
            cartProd.clear();
        }
    }

    public static void userDetails() {
        System.out.println("-------------------------------------");
        System.out.println("UserName: " + AmazonDriver.usname);
        System.out.println("Password: " + AmazonDriver.pswd);
        System.out.println("-------------------------------------");
    }
}

class AmazonDriver {
    static Scanner sc = new Scanner(System.in);
    static String usname;
    static String pswd;

    public static void homePage() {
        int ch = 0;
        do {
            System.out.println("\n===== AMAZON HOME =====");
            System.out.println("1. See products ");
            System.out.println("2. Add products");
            System.out.println("3. Check cart");
            System.out.println("4. Checkout");
            System.out.println("5. User details");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    Products.dispProducts(sc);
                    break;
                case 2:
                    Products.addProduct(sc);
                    break;
                case 3:
                    Products.cart();
                    break;
                case 4:
                    Products.checkout();
                    break;
                case 5:
                    Products.userDetails();
                    break;
                case 6:
                    System.out.println("Exiting......................");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (ch != 6);
    }

    public static void login() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Welcome to amazon.............");
        System.out.print("Enter username: ");
        usname = sc.next();
        System.out.print("Enter Password: ");
        pswd = sc.next();

        if (usname.equals("amey") && pswd.equals("ameyp686")) {
            AmazonDriver.homePage();
        } else {
            System.out.println("Provide right credentials....");
        }
    }

    public static void main(String[] args) {
        System.out.println("AMAZON...............");
        System.out.println("Largest online marketplace in the world.\nSells books, electronics, fashion, groceries, home products, etc.\nServices like Amazon Prime (fast delivery, streaming).");

        System.out.print("Do you want to login (y/n): ");
        char ch = sc.next().charAt(0);

        if (ch == 'y' || ch == 'Y') {
            login();
        } else if (ch == 'n' || ch == 'N') {
            System.out.println("Keep exploring....");
        } else {
            System.out.println("Please enter correct input....");
        }
    }
}
