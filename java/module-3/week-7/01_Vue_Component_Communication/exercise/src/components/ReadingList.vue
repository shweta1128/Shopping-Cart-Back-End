<template>
  <div class="book-container"  >
    <book-card v-for="book in $store.state.books" v-bind:key="book.isbn" v-bind:book="book" />
    <!-- <new-book-form v-for="book in $store.state.books" -->
  
</template>

<script>
import BookCard from './BookCard';
// import NewBookForm from './NewBookForm.vue';
export default {
    name: 'reading-list',
       components: {
      BookCard,
      // NewBookForm
    }
  
  
    

}
</script>

<style>
.book-container {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>