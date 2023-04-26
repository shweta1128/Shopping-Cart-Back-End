package com.techelevator.Services;

import com.techelevator.dao.CartItemDao;
import com.techelevator.dao.ProductDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Cart;
import com.techelevator.model.CartItem;
import com.techelevator.model.Product;
import com.techelevator.model.User;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Principal;
import java.util.List;


@Component
public class CartServices {


    private UserDao userDao;
    private ProductDao productDao;
    private CartItemDao cartItemDao;
    private TaxServices taxServices;

    public CartServices(UserDao userDao, ProductDao productDao, CartItemDao cartItemDao, TaxServices taxServices) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.cartItemDao = cartItemDao;
        this.taxServices = taxServices;
    }


    public BigDecimal subTotalOfAllProducts(){

        return null;
    }

    public Cart getAllItemsOfCart(Principal principal){

        User user = getUser(principal);
        Integer userId = user.getId();
         List<CartItem> results = cartItemDao.getAllItemsInCart(userId);
            Cart cart = new Cart(results);
            List<Product> productResults = productDao.listOfProductId(userId);
           for(CartItem cartItem: results){
              for(Product product: productResults){
                 if(product.getProductId() == cartItem.getProductId()){
                     cartItem.setProduct(product);
                 }

              }

            }
           BigDecimal subTotal = cart.subTotalOfItems();
           cart.setSubTotal(subTotal);
           BigDecimal tax = subTotal.multiply(taxServices.getSalesTax(user.getStateCode()));
           cart.setTax(tax.setScale(2, RoundingMode.HALF_UP));
            return cart;
    }


    private Product getProducts(List<Product> getAllProducts, int productId){
        for(Product product: getAllProducts){
            if(product.getProductId() == productId){
                return product;
            }
        }
        return null;
    }

    private User getUser(Principal principal) {
        String username = principal.getName();
        User user = userDao.findByUsername(username);
        return user;
    }


}
