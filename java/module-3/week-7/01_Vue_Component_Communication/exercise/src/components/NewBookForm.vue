<template>
  <form class="new-book-form" v-on:submit.prevent="addBook">
      <input class="title-input"  placeholder="Title" type="text" id="title-input" v-model="book.title"> 
      <input  class="author-input"  placeholder="Author" type="text" name="" id="author-input" v-mode="book.author"> 
      <input class="isbn-input" placeholder="ISBN" type="text" id="isbn-input" v-model="book.isbn">

      <button>Save</button>
  </form>

</template>

<script>
export default {
    data() {
        return {
            book: {
                title: '',
                author:'',
                isbn: '',
                read:false
            }
        }
    },
    methods: {
        addBook() {
            this.$store.commit('SAVE_BOOK', this.book)

        }
        
    }


}
</script>

<style>
.new-book-form{
   margin: 15px;
 
}
.new-book-form > input, .new-book-form > button{
    margin:20px;
}
</style>