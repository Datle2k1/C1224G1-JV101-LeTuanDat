import {Box, Button, Card, CardContent, CardHeader, MenuItem, TextField} from "@mui/material";
import {useFormik} from "formik";
import * as Yup from "yup";
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import ProductService from "../../service/product.service.js";
import {useEffect, useState} from "react";
import productService from "../../service/product.service.js";

function ProductCreate() {
    const navigate = useNavigate();
    const today = new Date();
    const [categories, setCategories] = useState([]);

    today.setHours(0, 0, 0, 0);

    useEffect(() => {
        ProductService.getAllProducts().then(res => {
            const listId = res.data.map(it => parseInt(it.id.replace("PROD-", "")));
            const maxId = Math.max(...listId);
            const newId = `PROD-${String(maxId + 1).padStart(4, "0")}`;
            formik.setFieldValue("id", newId);
        });

        productService.getAllCategories().then(res => {
            setCategories(res.data.map(it => {
                return it.name;
            }));        })
    }, []);

    const formik = useFormik({
        initialValues: {
            id: "",
            category: "",
            name: "",
            description: "",
            quantity: "",
            price: "",
            importDate: today,
        },
        validationSchema: Yup.object({
            id: Yup.string()
                .matches(/^PROD-\d{4}$/, "Mã sản phẩm phải theo định dạng PROD-XXXX")
                .required("Mã sản phẩm là bắt buộc"),
            category: Yup.string().required("Loại sản phẩm là bắt buộc"),
            name: Yup.string().required("Tên sản phẩm là bắt buộc").min(2, "Tên quá ngắn"),
            description: Yup.string().required("Mô tả là bắt buộc"),
            quantity: Yup.number().required("Số lượng tồn kho là bắt buộc").integer("Phải là số nguyên").moreThan(0, "Phải lớn hơn 0"),
            price: Yup.number().required("Giá là bắt buộc").min(0, "Giá không thể âm"),
            importDate: Yup.date()
                .required("Ngày nhập là bắt buộc")
                .max(today, "Ngày nhập không được lớn hơn hiện tại"),
        }),
        onSubmit: values => {
            const date = new Date(values.importDate);

            const day = String(date.getDate()).padStart(2, '0');
            const month = String(date.getMonth() + 1).padStart(2, '0');
            const year = date.getFullYear();

            const formattedDate = `${day}/${month}/${year}`; // dd/MM/yyyy

            const formattedValues = {
                ...values,
                importDate: formattedDate,
            };

            ProductService.createProduct(formattedValues)
                .then(() => {
                    toast.success("Tạo sản phẩm thành công");
                    navigate("/products");
                })
                .catch(() => {
                    toast.error("Tạo sản phẩm thất bại");
                });
        }
    });

    return (
        <Box display="flex" justifyContent="center" alignItems="center" minHeight="100vh">
            <Card sx={{ width: 600, p: 3 }}>
                <CardHeader title="Tạo sản phẩm mới" sx={{ textAlign: "center" }} />
                <CardContent>
                    <Box component="form" onSubmit={formik.handleSubmit} sx={{ display: "flex", flexDirection: "column", gap: 2 }}>
                        <TextField
                            label="Mã sản phẩm"
                            name="id"
                            fullWidth
                            required
                            value={formik.values.id}
                            onChange={formik.handleChange}
                            error={formik.touched.id && Boolean(formik.errors.id)}
                            helperText={formik.touched.id && formik.errors.id}
                            disabled={true}
                        />

                        <TextField
                            select
                            label="Thể loại"
                            name="category"
                            fullWidth
                            required
                            value={formik.values.category}
                            onChange={formik.handleChange}
                            error={formik.touched.category && Boolean(formik.errors.category)}
                            helperText={formik.touched.category && formik.errors.category}
                        >
                            {categories.map(cat => (
                                <MenuItem key={cat} value={cat}>{cat}</MenuItem>
                            ))}
                        </TextField>

                        <TextField
                            label="Tên sản phẩm"
                            name="name"
                            fullWidth
                            required
                            value={formik.values.name}
                            onChange={formik.handleChange}
                            error={formik.touched.name && Boolean(formik.errors.name)}
                            helperText={formik.touched.name && formik.errors.name}
                        />

                        <TextField
                            label="Mô tả"
                            name="description"
                            fullWidth
                            required
                            value={formik.values.description}
                            onChange={formik.handleChange}
                            error={formik.touched.description && Boolean(formik.errors.description)}
                            helperText={formik.touched.description && formik.errors.description}
                        />

                        <TextField
                            label="Tồn kho"
                            name="quantity"
                            fullWidth
                            required
                            type="number"
                            value={formik.values.quantity}
                            onChange={formik.handleChange}
                            error={formik.touched.quantity && Boolean(formik.errors.quantity)}
                            helperText={formik.touched.quantity && formik.errors.quantity}
                        />

                        <TextField
                            label="Giá (VND)"
                            name="price"
                            fullWidth
                            required
                            type="number"
                            value={formik.values.price}
                            onChange={formik.handleChange}
                            error={formik.touched.price && Boolean(formik.errors.price)}
                            helperText={formik.touched.price && formik.errors.price}
                        />

                        <TextField
                            label="Ngày nhập"
                            name="importDate"
                            fullWidth
                            required
                            type="date"
                            InputLabelProps={{ shrink: true }}
                            value={formik.values.importDate}
                            onChange={formik.handleChange}
                            error={formik.touched.importDate && Boolean(formik.errors.importDate)}
                            helperText={formik.touched.importDate && formik.errors.importDate}
                        />

                        <Button type="submit" variant="contained" color="primary" fullWidth>
                            Tạo sản phẩm
                        </Button>
                    </Box>
                </CardContent>
            </Card>
        </Box>
    );
}

export default ProductCreate;
