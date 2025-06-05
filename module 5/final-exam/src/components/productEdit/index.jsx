import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {useFormik} from "formik";
import * as Yup from "yup";
import {toast} from "react-toastify";
import {
    Box,
    Button,
    Card,
    CardContent,
    CardHeader,
    MenuItem,
    TextField
} from "@mui/material";
import ProductService from "../../service/product.service.js";
import productService from "../../service/product.service.js";
import dayjs from "dayjs";

function ProductEdit() {
    const {id} = useParams();
    const navigate = useNavigate();
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        productService.getAllCategories().then(res => {
            setCategories(res.data);
        })
    }, []);

    const productForm = useFormik({
        initialValues: {
            id: "",
            name: "",
            description: "",
            category: "",
            price: "",
            quantity: "",
            importDate: "",
        },
        validationSchema: Yup.object({
            id: Yup.string().required("Mã sản phẩm là bắt buộc").matches(/^PROD-\d{4}$/, "Định dạng: PROD-XXXX"),
            name: Yup.string().required("Tên sản phẩm là bắt buộc").min(2, "Ít nhất 2 ký tự"),
            description: Yup.string().required("Mô tả là bắt buộc"),
            category: Yup.string().required("Thể loại là bắt buộc"),
            price: Yup.number().required("Giá là bắt buộc").min(0, "Giá không thể âm"),
            quantity: Yup.number().required("Số lượng là bắt buộc").integer("Phải là số nguyên").moreThan(0, "Phải lớn hơn 0"),
            importDate: Yup.date()
                .required("Ngày nhập là bắt buộc")
                .max(new Date(), "Ngày nhập không được lớn hơn hôm nay")
        }),
        onSubmit: (values) => {
            ProductService.updateProduct(values, id).then(() => {
                toast.success("Cập nhật sản phẩm thành công");
                navigate("/products");
            });
        }
    });

    useEffect(() => {
        ProductService.getProductById(id).then((res) => {
            const data = res.data;
            productForm.setValues({
                id: data.id,
                name: data.name,
                description: data.description,
                category: data.category,
                price: data.price,
                quantity: data.quantity,
                importDate: dayjs(data.importDate).format("YYYY-MM-DD"),
            });
        });
    }, [id]);

    return (
        <Card>
            <CardHeader title="Cập nhật sản phẩm"/>
            <CardContent>
                <Box
                    component="form"
                    onSubmit={productForm.handleSubmit}
                    sx={{"& .MuiTextField-root": {m: 1, width: "100%"}}}
                >
                    <TextField
                        label="Mã sản phẩm"
                        name="id"
                        value={productForm.values.id}
                        onChange={productForm.handleChange}
                        error={productForm.touched.id && Boolean(productForm.errors.id)}
                        helperText={productForm.touched.id && productForm.errors.id}
                        disabled={true}
                    />
                    <TextField
                        label="Tên sản phẩm"
                        name="name"
                        value={productForm.values.name}
                        onChange={productForm.handleChange}
                        error={productForm.touched.name && Boolean(productForm.errors.name)}
                        helperText={productForm.touched.name && productForm.errors.name}
                    />
                    <TextField
                        label="Mô tả"
                        name="description"
                        value={productForm.values.description}
                        onChange={productForm.handleChange}
                        error={productForm.touched.description && Boolean(productForm.errors.description)}
                        helperText={productForm.touched.description && productForm.errors.description}
                    />
                    <TextField
                        select
                        label="Thể loại"
                        name="category"
                        value={productForm.values.category}
                        onChange={productForm.handleChange}
                        error={productForm.touched.category && Boolean(productForm.errors.category)}
                        helperText={productForm.touched.category && productForm.errors.category}
                    >
                        {categories.map((option) => (
                            <MenuItem key={option} value={option}>
                                {option}
                            </MenuItem>
                        ))}
                    </TextField>
                    <TextField
                        label="Giá"
                        name="price"
                        type="number"
                        value={productForm.values.price}
                        onChange={productForm.handleChange}
                        error={productForm.touched.price && Boolean(productForm.errors.price)}
                        helperText={productForm.touched.price && productForm.errors.price}
                    />
                    <TextField
                        label="Số lượng"
                        name="quantity"
                        type="number"
                        value={productForm.values.quantity}
                        onChange={productForm.handleChange}
                        error={productForm.touched.quantity && Boolean(productForm.errors.quantity)}
                        helperText={productForm.touched.quantity && productForm.errors.quantity}
                    />
                    <TextField
                        label="Ngày nhập"
                        name="importDate"
                        type="date"
                        value={productForm.values.importDate}
                        onChange={productForm.handleChange}
                        InputLabelProps={{shrink: true}}
                        error={productForm.touched.importDate && Boolean(productForm.errors.importDate)}
                        helperText={productForm.touched.importDate && productForm.errors.importDate}
                    />

                    <Button type="submit" variant="contained" color="primary">
                        Cập nhật sản phẩm
                    </Button>
                </Box>
            </CardContent>
        </Card>
    );
}

export default ProductEdit;
