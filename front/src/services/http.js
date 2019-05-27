import axios from 'axios';
import store from '../store.js';

const http = axios.create ({
    baseURL: 'http://localhost:8081/api/index.php',
    timeout: 1000,
    headers: {'Content-Type': 'application/json'},
});

http.interceptors.request.use (
    function (config) {
        const token = store.state.token;
        if (token) config.headers.Authorization = `Bearer ${token}`;
        return config;
    },
    function (error) {
        return Promise.reject (error);
    }
);

export default http;