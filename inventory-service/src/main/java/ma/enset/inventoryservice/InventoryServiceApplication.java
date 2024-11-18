package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entites.Product;
import ma.enset.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            // Ajouter des produits
            Product product1 = productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Laptop")
                            .price(800.0)
                            .quantity(10)
                            .build()
            );

            Product product2 = productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Smartphone")
                            .price(500.0)
                            .quantity(20)
                            .build()
            );

            Product product3 = productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Tablet")
                            .price(300.0)
                            .quantity(15)
                            .build()
            );

            Product product4 = productRepository.save(
                    Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Monitor")
                            .price(200.0)
                            .quantity(25)
                            .build()
            );

            // Imprimer les produits dans la console
            productRepository.findAll().forEach(product -> {
                System.out.println("Product: " + product.getName() +
                        ", Price: " + product.getPrice() +
                        ", Quantity: " + product.getQuantity());
            });
        };
    }
}
