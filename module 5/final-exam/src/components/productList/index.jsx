import React, {useEffect, useState} from "react";

import {toast} from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import {useNavigate} from "react-router-dom";
import ProductService from "../../service/product.service.js";
import productService from "../../service/product.service.js";

function ProductList() {
    const [products, setProducts] = useState([]);
    const [loading, setLoading] = useState(false);
    const [searchTerm, setSearchTerm] = useState("");
    const [categoryFilter, setCategoryFilter] = useState("");
    const [categories, setCategories] = useState([]);
    const navigate = useNavigate();


    useEffect(() => {
        productService.getAllCategories().then(res => {
            setCategories(res.data.map(it => {
                return it.name;
            }));
        })
    }, []);

    useEffect(() => {
        setLoading(true);
        ProductService.getAllProducts()
            .then((res) => {
                let filtered = res.data;

                if (searchTerm) {
                    filtered = filtered.filter((p) =>
                        p.name.toLowerCase().includes(searchTerm.toLowerCase())
                    );
                }

                if (categoryFilter) {
                    filtered = filtered.filter((p) => p.category === categoryFilter);
                }

                filtered.sort((a, b) => a.name.localeCompare(b.name));
                const result = filtered.map(it => {
                    return {...it,stt: filtered.indexOf(it) + 1}
                });

                setProducts(result);
                setLoading(false);
            })
            .catch(() => {
                toast.error("Lỗi khi tải dữ liệu sản phẩm");
                setLoading(false);
            });
    }, [searchTerm, categoryFilter]);

    const handleDelete = (id) => {
        if (window.confirm("Bạn có chắc chắn muốn xoá sản phẩm này không?")) {
            ProductService.deleteProductById(id).then(() => {
                toast.success("Đã xoá sản phẩm thành công");
                setProducts(products.filter((p) => p.id !== id));
            });
        }
    };

    return (
        <div className="container">
            <h2>Danh sách sản phẩm</h2>

            <div style={{ display: "flex", gap: "1rem", marginBottom: "1rem" }}>
                <input
                    type="text"
                    placeholder="Tìm theo tên"
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                />

                <select
                    value={categoryFilter}
                    onChange={(e) => setCategoryFilter(e.target.value)}
                >
                    <option value="">Tất cả thể loại</option>
                    {categories.map((cat) => (
                        <option key={cat} value={cat}>
                            {cat}
                        </option>
                    ))}
                </select>

                <button onClick={() => navigate("/products/create")}>Thêm mới</button>
            </div>

            {loading ? (
                <p>Đang tải...</p>
            ) : products.length === 0 ? (
                <p>Không có kết quả phù hợp.</p>
            ) : (
                <table border="1" cellPadding="8" style={{ width: "100%" }}>
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã</th>
                        <th>Tên</th>
                        <th>Mô tả</th>
                        <th>Thể loại</th>
                        <th>Giá</th>
                        <th>Số lượng</th>
                        <th>Ngày nhập</th>
                        <th>Hành động</th>
                    </tr>
                    </thead>
                    <tbody>
                    {products.map((p) => (
                        <tr key={p.id}>
                            <td>{p.stt}</td>
                            <td>{p.id}</td>
                            <td>{p.name}</td>
                            <td>{p.description}</td>
                            <td>{p.category}</td>
                            <td>{p.price}</td>
                            <td>{p.quantity}</td>
                            <td>{p.importDate}</td>
                            <td>
                                <button onClick={() => navigate(`/products/${p.id}`)}>
                                    Sửa
                                </button>{" "}
                                <button onClick={() => handleDelete(p.id)}>Xoá</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            )}
        </div>
    );
}

export default ProductList;

