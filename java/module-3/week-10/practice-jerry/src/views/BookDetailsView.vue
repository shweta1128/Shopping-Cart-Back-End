<template>
  <loading-spinner v-if="isLoading" />
  <div v-else class="view-container">
    <header class="view-header">
      <h1>Book Details</h1>
    </header>
    <div id="view-content">
      <div class="error" v-show="error">
        <p>
          Sorry! Something unexpected happened. {{ error }} Please try again
          later.
        </p>
      </div>
      <book-details v-show="!error" v-bind:book="bookData" />
    </div>
  </div>
</template>

<script>
import bookService from "../services/BookService";
import LoadingSpinner from "../components/LoadingSpinner.vue";
import BookDetails from "../components/BookDetails.vue";

export default {
  components: { LoadingSpinner, BookDetails },
  data() {
    return {
      error: null,
      isLoading: true,
      bookId: "",
      bookData: {},
    };
  },
  created() {
    this.isLoading = true;
    this.bookId = this.$route.params.bookId;
    bookService
      .getBookById(this.bookId)
      .then((response) => {
        this.isLoading = false;

        if (response.data) {
          this.bookData = response.data;
          this.error = null;
        } else {
          this.error = `Could not get book for id ${this.bookId}.`;
          //this.$router.push({ name: "notFound" });
        }
      })
      .catch((error) => {
        this.isLoading = false;
        this.error = `Could not get book for id ${this.bookId}.`;
        console.log(this.error, error.response);
        this.$router.push({ name: "notFound" });
      });
  },
};
</script>

<style>
</style>