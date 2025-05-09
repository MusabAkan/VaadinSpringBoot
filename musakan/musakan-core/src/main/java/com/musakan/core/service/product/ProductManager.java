package com.musakan.core.service.product;

import com.musakan.core.dataAccess.ProductRepository;
import com.musakan.core.dataAccess.base.BaseRepository;
import com.musakan.core.entities.Product;
import com.musakan.core.service.base.BaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductManager extends BaseManager<Product> implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    protected BaseRepository<Product> getRepository() {
        return productRepository;
    }
}