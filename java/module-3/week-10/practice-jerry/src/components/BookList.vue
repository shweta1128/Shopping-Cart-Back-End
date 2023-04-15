<template>
  <div id="card-container">
    <div v-for="(b, index) of bookList" v-bind:key="index">
      <book-card v-bind:book="b"/>
    </div>
  </div>
</template>

<script>
import BookCard from './BookCard.vue';
// import BookCard from "./BookCard.vue";
export default {
  components: { BookCard },
  // components: { BookCard },
  props: ["bookList"],
};
</script>

<style scoped>
#card-container {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
  justify-content: space-around;
}
</style>