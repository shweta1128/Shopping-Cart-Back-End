import axios from 'axios';

export default {
    list() {
        return axios.get('/products')
    },
    getProductId(productId){
        return axios.get(`/products/${productId}`)
    },
    search() {
        return axios.get(`/products`)
    }

}