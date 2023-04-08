<template>
  <section>
    <table class="product-table">
      <thead>
        <th>SKU</th>
        <th>Products</th>
        <th>Price</th>
      </thead>
      <tbody>
        <tr v-for="product in products" v-bind:key="product.productId">
          <td>{{product.productSku}}</td> 
          <td>{{product.name}}</td>
          <td>${{product.price}}</td>
          <td><font-awesome-icon icon="fa-solid fa-cart-plus" class="cart"/></td> 
        </tr>

      </tbody>
    </table>
  </section>
</template>

<script>
export default {
  props: ['products']

};
</script>

<style>
.product-table {
  border-collapse: collapse;
  width: 100%;
}

.product-table th,
.product-table td {
  padding: 10px;
  text-align: left;
  

}

.product-table th {
  background-color: #f5e3e3;
  color: #555;
  font-weight: bold;
 
}

.product-table tr:nth-child(even) {
  background-color: #f5e3e3;
}

.product-table tr:hover {
  background-color: #ddd;
}

.cart {
  color: #555;
  cursor: pointer;
  font-size: 16px;
}

.cart:hover {
  color: #000;
}
</style>