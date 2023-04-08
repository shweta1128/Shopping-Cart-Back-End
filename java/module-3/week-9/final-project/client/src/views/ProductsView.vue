<template>
  <div class="home">
    <div id="heading-line">
      <h1>
        Products
        
        <loading-spinner id="spinner" v-bind:spin="isLoading" />
      </h1>
    </div>
    <!-- <h2>Loading spinner demonstration</h2>
      
    <p>
      This is a demonstration of how you can show or hide a "spinner" icon to
      let the user know something is happening. Before calling an API, you'd set
      the data property <code>isLoading</code> to <code>true</code>. When the
      call completes, set it to <code>false</code>.
    </p>
    <p>
      For this demonstration, clicking the checkbox below sets
      <code>isLoading</code> to <code>true</code>, so it simulates what the user
      would see when your app is accessing an API.
    </p>
    <input type="checkbox" name="loading" id="loading" v-model="isLoading" /> Is
    Loading -->
    <!-- <p id="login-message" v-if="!isLoggedIn">
      Welcome! You may browse anonymously as much as you wish,<br />
      but you must
      <router-link v-bind:to="{ name: 'login' }">Login</router-link> to add
      items to your shopping cart.
    </p> -->
    <!-- <h2>Font-awesome demonstration</h2> -->
    <!-- <p>
      This code shows you how you can include Font-awesome icons on your page. Below are two icons: 
      one to indicate a "tile" view of products, and another to indicate a "table" view. There's also a little bit
      of styling to get you started, but you can style it your own way. And there's a property to track which view is "active".
    </p> -->
  <div class="icon-search">
    <font-awesome-icon
      v-bind:class="{ 'view-icon': true, active: cardView }"
      v-on:click="cardView = true"
      icon="fa-solid fa-grip"
      title="View tiles"
    />
    <font-awesome-icon
      v-bind:class="{ 'view-icon': true, active: !cardView }"
      v-on:click="cardView = false"
      icon="fa-solid fa-table"
      title="View table"
    />
    <div id="searchBar">
    <input type="text" id="search" placeholder="Search..." v-model="searchTerm" v-on="search" >
    <button id="searchButton" v-on="search"><font-awesome-icon class="fa-magnifying-glass fa-solid"/></button>
  </div>
  </div>
    <p v-if="cardView">
      SS Solar Geek products are designed and manufactured to harness the power of the sun and provide sustainable energy solutions. These products may include solar panels, inverters, batteries, charge controllers, and other accessories necessary for setting up a complete solar power system. SS Solar Geek products are typically engineered for high efficiency and durability, with advanced features such as MPPT (Maximum Power Point Tracking) technology, multiple connectivity options, and remote monitoring capabilities. 
    </p>
    <!-- <p id="login-message" v-if="!isLoggedIn">
     
      <router-link v-bind:to="{name: 'login'}"> Login</router-link> -->

    <!-- </p> -->
   
   <products-page  v-if="cardView" v-bind:products="products"/>
   <product-table v-if="!cardView" v-bind:products="products"/>
   
  </div>
  




</template>

<script>
import LoadingSpinner from "../components/LoadingSpinner.vue";
import ProductsPage from '../components/ProductsPage.vue';
import ProductTable from '../components/ProductTable.vue';
import productService from "../services/ProductService";

// import productTiledView

export default {
  name: "ProductsView",
  components: {
    LoadingSpinner,
    ProductsPage,
    ProductTable,
  

  },
  data() {
    
    return {
      searchTerm: "",
      isLoading: false,
      cardView: true,
      products: [],
      
    };
  },

  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
  },

  methods: {
    search() {
      productService.search(this.filter)
      .then(response => {
        this.products = response.data
      })

    }
   
  },

  created() {
    productService.list().then((response) => {
      this.products = response.data;
    });
  },
};
</script>

<style scoped>
#spinner {
  color: green;
}

.view-icon {
  font-size: 1.2rem;
  margin-right: 7px;
  padding: 3px;
  color: #444;
  border-radius: 3px;
}

.view-icon.active {
  background-color: lightgreen;
}

.view-icon:not(.active) {
  font-size: 1.2rem;
  margin-right: 7px;
  cursor: pointer;
}

#searchBar {
    display: inline-block;
   
    border: 1px solid red;
  
    /* width: 300px;
    height:40px; */
  

}
#searchButton {
    cursor: pointer;
    background-color: black;
    border:none;
}
#search{
    border:none;
    background-color: transparent;
    width: 200px;
}
.icon{
    cursor: pointer;
}


.view-icon:not(.active):hover {
  color: blue;
  background-color: rgba(255, 255, 255, 0.7);
}
</style>