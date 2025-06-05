import './App.css';
import {Route, Routes} from "react-router";
import ProductList from "./components/productList/index.jsx";
import ProductCreate from "./components/productCreate/index.jsx";
import ProductEdit from "./components/productEdit/index.jsx";

function App() {
    return (
        <>
            <Routes>
                <Route path="/products" element={<ProductList/>}/>
                <Route path="/products/create" element={<ProductCreate/>}/>
                <Route path="/products/:id" element={<ProductEdit/>}/>
            </Routes>
        </>
    );
}

export default App;
