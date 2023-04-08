

<template>
  <section>
    <div class="header">
      <h1>{{ product.productName }}</h1>
      <loading-spinner id="spinner" v-bind:spin="isLoading" />
    </div>
    <div id="searchBar">
      <button class="cart1" v-on:click="addToCart" v-bind:disabled="itemInCart">
        <font-awesome-icon icon="fa-solid fa-cart-plus" />Add to Cart
      </button>

      <!-- <button id="searchButton" v-on="search"><font-awesome-icon class="fa-magnifying-glass fa-solid"/></button> -->
    </div>
    <div class="product-details">
      <h2>Details</h2>
      <p>{{ product.productSku }}</p>
      <p>{{ product.price }}</p>
      <p>{{ product.description }}</p>
      <img v-bind:src="product.imageName" />
    </div>

    <!-- <product-service /> -->
  </section>
</template>

<script>
import productService from "../services/ProductService";
import LoadingSpinner from "../components/LoadingSpinner.vue";

export default {
  name: "DetailView",
  components: {
    LoadingSpinner,
    // productService,
  },
  data() {
    return {
      product: {},
      isLoading: false,
      itemInCart: false,
      searchTerm: "",
      cart: [],
    };
  },
  created() {
    productService
      .getProductId(this.$route.params.productId)
      .then((response) => {
        this.product = response.data;
      });
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
  },
  methods: {
    addToCart(item) {
      this.cart.push(item);
      this.itemInCart = true;
    },
  },
};
</script>

<style>

/* .header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
} */

.cart1 {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  transition: all 0.3s ease;
}

/* .cart:hover {
  background-color: #0062cc;
} */

/* .product-details {
  display: flex;
  flex-direction: column;
  align-items: center;
} */

/* .product-image {
  width: 100%;
  max-width: 500px;
  margin-bottom: 20px;
} */

/* .product-image img {
  width: 100%;
  height: auto;
  object-fit: contain;
} */

/* .product-info {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
} */

/* .sku {
  font-weight: bold;
  font-size: 20px;
  margin-bottom: 10px;
} */

/* .price {
  font-weight: bold;
  font-size: 24px;
  margin-bottom: 10px;
} */

/* .description {
  font-size: 16px;
  margin-bottom: 20px;
} */
</style>