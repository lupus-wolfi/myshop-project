package com.myshop;
// Week 1-12: Test all modules in console
// Create products, add to cart, make orders, simulate payment, generate reports

import com.myshop.console.Product;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Product p1 = Product.builder()
                .id(1L)
                .name("Test1")
                .price(new BigDecimal("9.99"))
                .taxRate(new BigDecimal("0.19"))
                .build();

        Product p2 = Product.builder()
                .id(2L)
                .name("Test2")
                .price(new BigDecimal("19.99"))
                .taxRate(new BigDecimal("0.19"))
                .build();
        Product p3 = Product.builder()
                .id(3L)
                .name("Test3")
                .price(new BigDecimal("29.99"))
                .taxRate(new BigDecimal("0.19"))
                .build();

        boolean whileRunning = true;
        while (whileRunning){
            System.out.println("Before changes");
            System.out.println(p1);
            System.out.println("Enter: \n 1. to set id and name \n 9. to end program");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println("Enter new ID:");
                String idInput = scanner.nextLine();
                Long newId = Long.parseLong(idInput);
                p1.setId(newId);

                System.out.println("Enter new name:");
                String newName = scanner.nextLine();
                p1.setName(newName);

                System.out.println("Enter new price:");
                String priceInput = scanner.nextLine();
                BigDecimal newPrice = new BigDecimal(priceInput);
                p1.setPrice(newPrice);

                System.out.println("Enter new taxrate:");
                String taxRateInput = scanner.nextLine();
                BigDecimal newTaxRate = new BigDecimal(taxRateInput);
                p1.setTaxRate(newTaxRate);

                System.out.println("p1 equals p2? " + p1.equals(p2));
            } else if (input.equals("9")) {
                whileRunning = false;
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
        System.out.println("Program ended. Week 1 test completed.");
        scanner.close();
    }
}
