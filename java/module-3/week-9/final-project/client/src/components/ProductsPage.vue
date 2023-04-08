<template>
<section class="container">
<div class="product-card" v-for="product in products" v-bind:key="product.productId">
  <div class="sku-price">
  <div class="product-sku">{{product.productSku}}</div>
  <div class="product-price"> ${{product.price}}</div>
  </div>
  <router-link v-bind:to="{name: 'productDetails', params: {productId: product.productId}}">
  <div class="product-name">{{product.name}}</div>
  </router-link>
  <!-- <div class="product-description">{{product.description}}</div> -->
  <div class="image-container">
  <img class="product-image"  v-bind:src="product.imageName"/>
  </div>
  <div v-if="isLoggedIn">
  <font-awesome-icon icon="fa-solid fa-cart-plus" class="cart"/>
  </div>
  
  
</div>
 </section> 
</template>

<script>

export default {

  props:{
     products: []
  },
  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
  }
}

</script>


<style>
.container{
  display: flex;
    flex-wrap: wrap;
    margin-top: 100px;
    justify-content: flex-start;
    gap: 150px;
}
.product-image > img {
   max-width: 85%;
   max-height: 85%;
   border-radius: 20px;
   
   
}
.image-container {
    display: flex;
    justify-content: center;
    align-items: center;
    
   
   
}
.product-card{
     border:3px solid rgb(182, 28, 28);
     padding: 10px;
     background-color: rgb(241, 221, 221);
     height: 300px;
     width: 300px;
     display: block;
     margin-left:10px;
     grid-template-columns: 1fr 1fr ;
    /* grid-template-rows: 1fr 1fr 3fr 1fr; */
    grid-template-areas: "sku price"
                         "product-name product-name"
                         "product-image product-image"
                         ". cart";
}
.sku-price {
  display: flex;
  justify-content: space-between;
  
}

.product-price{
    display: flex;
    justify-content: flex-end;
    margin-top: 3px;
}

.product-name{
    grid-area:product-name;
    cursor: pointer;
}
.product-image{
    grid-area:product-image;
    margin: 10px;
    max-width: 85%;
    height: 200px;
     border-radius: 20px;
}
.cart{
    display: flex;
    justify-content: flex-end;
    grid-area:cart;
   
}
.product-sku{
    grid-area: sku;

}

</style>