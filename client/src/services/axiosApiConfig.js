import axios from "axios";

const api_url = 'http://localhost:9192';

const axiosInstance = axios.create({
    baseURL: `${api_url}`,
    headers: {
        'Content-Type': 'application/json',
    },
});

axiosInstance.interceptors.request.use((config) => {
    const token = localStorage.getItem('token');
    if(token){
        config.headers['Authorization'] = `Bearer ${token}`;
    }
    return config;
})

export default axiosInstance;