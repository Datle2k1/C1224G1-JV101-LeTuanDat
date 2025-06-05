// Khai báo biến với kiểu dữ liệu
let message: string = "Xin chào, TypeScript!";
console.log(message);

// Định nghĩa một giao diện
interface Person {
    name: string;
    age: number;
}

// Hàm nhận vào một tham số kiểu Person và trả về chuỗi
function greet(person: Person): string {
    return `Chào ${person.name}, bạn ${person.age} tuổi!`;
}

// Sử dụng giao diện và hàm
const user: Person = { name: "Nam", age: 25 };
console.log(greet(user));

// Hàm tính tổng với kiểu trả về
function add(a: number, b: number): number {
    return a + b;
}

console.log(add(5, 3)); // Kết quả: 8
