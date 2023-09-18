package com.example.productrepository.products;

import com.example.productrepository.products.models.NewProduct;
import com.example.productrepository.products.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {

    private final ProductRepository productRepository;
    private final IdService idService;

    public ProductService(ProductRepository productRepository, IdService idService) {
        this.productRepository = productRepository;
        this.idService = idService;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(NewProduct newProduct) {

        Product product = new Product(
                idService.randomId(),
                newProduct.title(),
                newProduct.price()
                );

        return productRepository.save(product);
    }

    public Product findById(String id){
       return productRepository.findById(id).orElseThrow();
    }

    public Product updateProduct(String id, NewProduct newProduct){
          Product productToSave = new Product(id,newProduct.title(),newProduct.price());
          return productRepository.save(productToSave);



    }

    public void deleteProduct(String id){
     productRepository.deleteById(id);
    }

}


