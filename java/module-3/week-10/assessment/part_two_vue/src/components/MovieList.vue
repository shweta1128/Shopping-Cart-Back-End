<template>
  <div id="card-container">
    <!-- {{JSON.stringify(movieList)}} -->
    <movie-card v-for="movie in movieList" v-bind:key="movie.id" :movie="movie"  />
  </div>
</template>

<script>
import MovieCard from './MovieCard.vue'
export default {
  components: { MovieCard },
  props: ['movieList']
}
</script>

<style scoped>
#card-container {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
  justify-content: space-around;
}
</style>