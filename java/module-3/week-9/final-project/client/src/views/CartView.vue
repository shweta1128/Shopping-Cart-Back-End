<template>
  <section>      
      <div>
          <h1>
        Shopping Cart <loading-spinner id="spinner" v-bind:spin="isLoading" />
      </h1>
          <!-- <button class="shopping-cart" v-on:click="clearCart" >
        <font-awesome-icon icon="fa-solid fa-trash" />Clear Cart
      </button> -->
      </div>
      <table>
          <thead>
              <th>Quantity</th>
              <th>Product</th>
              <th>Price</th>
              <th>Amount</th>
              <th>Remove</th>
              </thead>
              <tbody>
                  <tr v-for="item in cart.cartItems" v-bind:key="item.cartItemId">
                      <td>{{item.quantity}}</td>
                      <td>{{item.product.name}}</td>
                      <td>{{item.product.price}}</td>
                      <td>{{item.quantity * item.product.price}}</td>

                  </tr>
              </tbody>
      </table>
  </section>
 
 
      
</template>

<script>
import cartService from "../services/CartService";
import LoadingSpinner from "../components/LoadingSpinner.vue";
export default {
    name: "CartView",
    components: {
        LoadingSpinner,
    },
    data() {
        return {
            isLoading: false,
            cart: {},
            cartItems: [],
            // products: [],
        }
    },
    created() {
        
    
         this.isLoading = true;
         cartService.getCart().then(response => {
          this.cart = response.data
          this.isLoading = false;
          this.cartItems = this.cart.cartItems;
      
      })
        
    }

}
</script>

<style>

</style>