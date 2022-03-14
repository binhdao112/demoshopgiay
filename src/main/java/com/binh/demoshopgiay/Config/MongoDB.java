package com.binh.demoshopgiay.Config;
<<<<<<< HEAD
import com.binh.demoshopgiay.Model.ProductModel;
import com.binh.demoshopgiay.Model.accountModel;
import com.binh.demoshopgiay.Repository.ProductRepository;
=======
>>>>>>> f0f0c7dfbb985317d35cf113345ca3aeabe0b27a
import com.binh.demoshopgiay.Repository.accountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

<<<<<<< HEAD
@EnableMongoRepositories(basePackageClasses = {accountRepository.class,ProductRepository.class})
@Configuration
public class MongoDB {
    @Bean
    CommandLineRunner commandLineRunner(accountRepository accountRepository,ProductRepository productRepository){
=======
@EnableMongoRepositories(basePackageClasses = accountRepository.class)
@Configuration
public class MongoDB {
    @Bean
    CommandLineRunner commandLineRunner(accountRepository accountRepository){
>>>>>>> f0f0c7dfbb985317d35cf113345ca3aeabe0b27a
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                accountRepository.save(new accountModel("binh","alo","123","user"));
<<<<<<< HEAD
//               ccountRepository.save(new accountModel("binh2","alo","123","user"));
//                System.out.println("adsadsads");
                if(productRepository.findAll().size()==0){
                    productRepository.save(new ProductModel("Giày 1", "s1.jpg",2000.0,20));
                    productRepository.save(new ProductModel("Giày 2", "s2.jpg",3000.0,20));
                    productRepository.save(new ProductModel("Giày 3", "s3.jpg",4000.0,20));
                    productRepository.save(new ProductModel("Giày 4", "s4.jpg",5000.0,20));
                    productRepository.save(new ProductModel("Giày 5", "s5.jpg",6000.0,20));
                    productRepository.save(new ProductModel("Giày 6", "s6.jpg",7000.0,20));
                    productRepository.save(new ProductModel("Giày 7", "s6.jpg",7000.0,20));
                    productRepository.save(new ProductModel("Giày 8", "s6.jpg",7000.0,20));
                    productRepository.save(new ProductModel("Giày 9", "s6.jpg",7000.0,20));
                    productRepository.save(new ProductModel("Giày 10", "s6.jpg",7000.0,20));
                    productRepository.save(new ProductModel("Giày 11", "s6.jpg",7000.0,20));
                }



=======
//                accountRepository.save(new accountModel("binh2","alo","123","user"));
>>>>>>> f0f0c7dfbb985317d35cf113345ca3aeabe0b27a
            }
        };
    }
}
