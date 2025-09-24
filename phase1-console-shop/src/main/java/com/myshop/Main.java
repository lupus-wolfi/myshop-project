package com.myshop;

import com.myshop.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();

        // Add some test products
        productService.addProduct(1L, "Test1", new BigDecimal("9.99"), new BigDecimal("0.19"));
        productService.addProduct(2L, "Test2", new BigDecimal("19.99"), new BigDecimal("0.19"));
        productService.addProduct(3L, "Test3", new BigDecimal("29.99"), new BigDecimal("0.19"));

        boolean whileRunning = true;

        while (whileRunning) {
            // Print product list
            System.out.println("\nProduct List:");
            for (var p : productService.getAllProducts()) {
                System.out.println(p);
            }

            // Show menu options
            System.out.println("\nEnter: \n" +
                    "1. Update product\n" +
                    "2. Add new product\n" +
                    "3. Remove product\n" +
                    "9. End program");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    // Update product
                    System.out.println("Enter product ID to update:");
                    Long updateId = Long.parseLong(scanner.nextLine());

                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();

                    System.out.println("Enter new price:");
                    BigDecimal newPrice = new BigDecimal(scanner.nextLine());

                    System.out.println("Enter new taxrate:");
                    BigDecimal newTaxRate = new BigDecimal(scanner.nextLine());

                    boolean updated = productService.updateProduct(updateId, newName, newPrice, newTaxRate);
                    System.out.println(updated ? "Product updated." : "Product with ID " + updateId + " not found.");
                    break;

                case "2":
                    // Add new product
                    try {
                        System.out.println("Enter new product ID:");
                        Long id = Long.parseLong(scanner.nextLine());

                        System.out.println("Enter product name:");
                        String name = scanner.nextLine();
                        if (name.isBlank()) {
                            name = "Empty";
                        }

                        System.out.println("Enter product price:");
                        String priceInput = scanner.nextLine();
                        BigDecimal price = priceInput.isBlank() ? BigDecimal.ZERO : new BigDecimal(priceInput);

                        System.out.println("Enter product taxrate:");
                        String taxRateInput = scanner.nextLine();
                        BigDecimal taxRate = taxRateInput.isBlank() ? BigDecimal.ZERO : new BigDecimal(taxRateInput);

                        productService.addProduct(id, name, price, taxRate);

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input: Please enter a valid number.");
                    }
                    break;

                case "3":
                    // Remove product
                    System.out.println("Enter product ID to remove:");
                    Long removeId = Long.parseLong(scanner.nextLine());

                    boolean removed = productService.removeProduct(removeId);
                    System.out.println(removed ? "Product removed successfully." : "Product with ID " + removeId + " not found.");
                    break;

                case "9":
                    // Exit program
                    whileRunning = false;
                    break;

                default:
                    System.out.println("Invalid input, try again.");
            }
        }

        // Program ended
        System.out.println("Program ended. Week 1 test completed.");
        scanner.close();
    }
}
