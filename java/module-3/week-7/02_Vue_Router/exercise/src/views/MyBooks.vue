<template>
  <div class="container">
      <router-link v-bind:to="{name: 'NewBook'}">NewBook</router-link>
      <reading-list />
  </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue'
export default {
  components: { ReadingList },

}
</script>

<style>

</style>