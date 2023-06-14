package com.NirmalCrudexample.sampleAPI.service;

import com.NirmalCrudexample.sampleAPI.entity.Product;
import com.NirmalCrudexample.sampleAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product SaveProduct(Product product) {
        return repository.save(product);
    }
        public List<Product> saveProducts(List<Product> products) {
            String a="test";
            return repository.saveAll(products);
      }

            public List<Product> getProducts () {
                return repository.findAll();
            }
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName (String name){
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !!"+id;   }

    public Product updateProduct(Product product) {
        Product existingproduct = repository.findById(product.getId()).orElse(null);
        existingproduct.setName(product.getName());
        existingproduct.setPrice(product.getPrice());
        existingproduct.setQuantity(product.getQuantity());
        return repository.save(existingproduct);

    }
}

