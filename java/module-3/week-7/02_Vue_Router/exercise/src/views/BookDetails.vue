<template>
<Book-details v-bind:book="getBook">

</Book-details>
</template>

<script>
import BookDetails from '../components/BookDetails.vue';
export default {
    components: {
 BookDetails 

    },
    computed: {
        getBook() {
            return this.$store.state.books.find((b) => {
                return b.isbn == this.$route.params.id


            });
        }
    }
   
}
</script>

<style>

</style>