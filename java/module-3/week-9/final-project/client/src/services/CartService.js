import axios from 'axios';

export default {
    getCart() {
        return axios.get('/cart');
    }
}
