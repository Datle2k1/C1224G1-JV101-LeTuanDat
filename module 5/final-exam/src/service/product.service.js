import { axiosInstance } from "../configs/axios.config.js";

class ProductService {
    static async getAllProducts() {
        return await axiosInstance.get("/products?_sort=name&_order=asc");
    }

    static async deleteProductById(id) {
        return await axiosInstance.delete(`/products/${id}`);
    }

    static async searchProductsByName(name) {
        return await axiosInstance.get(`/products?name_like=${name}&_sort=name&_order=asc`);
    }

    static async searchProductsByNameAndCategory(name, category) {
        return await axiosInstance.get(
            `/products?name_like=${name}&category=${category}&_sort=name&_order=asc`
        );
    }

    static async searchProductsByCategory(category) {
        return await axiosInstance.get(`/products?category=${category}&_sort=name&_order=asc`);
    }

    static async createProduct(data) {
        return await axiosInstance.post(`/products`, data);
    }

    static async getProductById(id) {
        return await axiosInstance.get(`/products/${id}`);
    }

    static async updateProduct(data, id) {
        return await axiosInstance.put(`/products/${id}`, data);
    }

    static async getAllCategories() {
        return await axiosInstance.get("/catetories");
    }
}

export default ProductService;
