package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entitiesEnum.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data : ");

        System.out.print("Name : ");
        String name = sc.nextLine();

        System.out.println("Email : ");
        String email = sc.next();

        System.out.println("Birthday date dd/MM/yyyy : ");
        Date birthdayDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthdayDate);

        System.out.println("Enter the order Data : ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.println("How many items to this order ? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.println("Product name : ");
            String productName = sc.next();

            System.out.println("Product Price: ");
            double price = sc.nextDouble();

            System.out.println("Quantity : ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, price);
            OrderItem orderItem = new OrderItem(quantity, price, product);
            order.addItem(orderItem);
        }

        System.out.println(order);


    }
}
