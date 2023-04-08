package com.techelevator.controller;


import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
/* As the readme says an unauthorised user, we don't need permitALl*/
//@PreAuthorize("permitAll")
@RequestMapping(path = "/products")
public class ProductController {
    private ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }



//    @RequestMapping( method = RequestMethod.GET)
//    public List<Product> productForSale() {
//        return productDao.productForSale();
//    }
    @RequestMapping(path = "/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId){
        return productDao.getProductById(productId);
    }

     @RequestMapping(path = "",  method = RequestMethod.GET)
     public List<Product> searchByProducts (@RequestParam(defaultValue = "") String productName, @RequestParam(defaultValue = "") String productSku) {
        if(!productName.equals("") && !productSku.equals("")){
            return productDao.productBySearch(productName,productSku);
        }
        else{
            return productDao.productForSale();
        }

    }
}
