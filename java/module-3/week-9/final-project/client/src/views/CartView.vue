<template>
  <section>      
      <div>
          <h1>
        Shopping Cart <loading-spinner id="spinner" v-bind:spin="isLoading" />
      </h1>
          <!-- <button class="shopping-cart" v-on:click="clearCart" >
        <font-awesome-icon icon="fa-solid fa-trash-can" />Clear Cart
      </button> -->
      </div>
      <table>
          <thead>
              <th>Quantity </th>
              <th>Product  </th>
              <th>Price    </th>
              <th>Amount   </th>
              <th>Remove   </th>
              </thead>
              <tbody >
                  <tr v-for="item in cart.cartItems" v-bind:key="item.cartItemId">
                      <td>{{item.quantity}}</td>
                      <td>{{item.product.name}}</td>
                      <td>${{item.product.price}}</td>
                      <td>${{item.quantity * item.product.price}}</td>
                      <td>{{"x"}}</td>
                      </tr>
                      
                      
                      <tr class="subTotal">
                          <td></td>
                          <td style="border-top: 5px solid #ccc">Items Subtotal</td>
                          <td></td>
                          <td>${{cart.subTotal}}</td>
                      </tr>
                      <tr>
                          <td>{{ }}</td>
                          <td>Tax</td>
                          <td>{{ }}</td>
                          <td>${{cart.tax}}</td>


                      </tr>
                      <tr>
                          <td>{{ }}</td>
                          <td>Total</td>
                          <td>{{ }}</td>
                          <td>${{cart.total}}</td>
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
th, td {
    padding: 10px;
    ext-align: left;
    border-bottom: 1px solid #ccc;
}
td:nth-child(3), td:nth-child(4) {
    text-align: right;
  }
  td:nth-child(5) {
    text-align: center;
  }
  .line {
      border-top: 1px solid #ccc;
      width: 10px;
      height: auto;
  } 
  tr.subTotal > td  {
      width: 5px;
      border-top: 1px solid #ccc;
      
  }

<style>

</style>