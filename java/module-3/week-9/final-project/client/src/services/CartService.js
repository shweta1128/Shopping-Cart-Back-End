import axios from 'axios';

export default {
    getCart() {
        return axios.get('/cart');
    },
    addItemsToCart(product) {
        const item = {
            productId: product.productId,
            quantity: 1,
        }
        return axios.post('/cart/items', item);
    }

}
