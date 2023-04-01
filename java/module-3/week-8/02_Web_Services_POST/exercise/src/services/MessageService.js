import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  get(id) {
    return http.get(`/messages/${id}`);
  },
  create(message){
    return http.post(`/Messages`, message)
  },
  update(id, message) {
    return http.put(`/Messages/${id}`, message)
  },
  delete(id) {
    return http.delete(`/Messages/${id}`)

  }

}
