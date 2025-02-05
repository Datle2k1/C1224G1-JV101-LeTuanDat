let container = document.getElementById("container");
let detail = document.getElementById("detail");
let students = [];
let student;

class Student {
    constructor(ten, ngaySinh, gioiTinh, lop, email, anh) {
        this._msv = newMSV();
        this._ten = ten;
        this._ngaySinh = ngaySinh;
        this._gioiTinh = gioiTinh;
        this._lop = lop;
        this._email = email;
        this._anh = anh;
    }


    get ten() {
        return this._ten;
    }

    set ten(value) {
        this._ten = value;
    }

    get ngaySinh() {
        return this._ngaySinh;
    }

    set ngaySinh(value) {
        this._ngaySinh = value;
    }

    get gioiTinh() {
        return this._gioiTinh;
    }

    set gioiTinh(value) {
        this._gioiTinh = value;
    }

    get lop() {
        return this._lop;
    }

    set lop(value) {
        this._lop = value;
    }

    get email() {
        return this._email;
    }

    set email(value) {
        this._email = value;
    }

    get anh() {
        return this._anh;
    }

    set anh(value) {
        this._anh = value;
    }

    get msv() {
        return this._msv;
    }

    set msv(value) {
        this._msv = value;
    }
}

function drawBoardManager() {
    let result = "<table id='main'>" +
        "    <colgroup>" +
        "        <col style=\"width: 10%;\">" +
        "        <col style=\"width: 20%;\">" +
        "        <col style=\"width: 10%;\">" +
        "        <col style=\"width: 5%;\">" +
        "        <col style=\"width: 10%;\">" +
        "        <col style=\"width: 5%;\">" +
        "        <col style=\"width: 10%;\">" +
        "    </colgroup>" +
        "    <tr>" +
        "        <th class='none_border'>" +
        "           <button type='button' id='add' onclick='drawBoardDetail()'>" +
        "                <img class='icon' id='add' alt='add' src='img/add.png'> Thêm mới học viên" +
        "           </button>" +
        "        </td>" +
        "        <th class='none_border'></th>" +
        "        <th class='none_border'></th>" +
        "        <th class='none_border'></th>" +
        "        <th class='none_border'></th>" +
        "        <th class='none_border'></th>" +
        "        <th class='none_border'></th>" +
        "    </tr>" +
        "    <tr>" +
        "        <th class = 'title'>Mã học viên</th>" +
        "        <th class = 'title'>Tên</th>" +
        "        <th class = 'title'>Ngày sinh</th>" +
        "        <th class = 'title'>Giới tính</th>" +
        "        <th class = 'title'>Email</th>" +
        "        <th class = 'title'>Lớp</th>" +
        "        <th class = 'title'>Tùy chọn</th>" +
        "    </tr>";
    for (let i = 0; i < students.length; i++) {
        result += `<tr><td>${students[i].msv}</td>
             <td>${students[i].ten}</td> 
             <td>${students[i].ngaySinh}</td> 
             <td>${students[i].gioiTinh}</td> 
             <td>${students[i].email}</td>
             <td>${students[i].lop}</td> 
             <td>
               <button type="button" onclick="removeStudent(${i})">Xóa</button>
               <button type="button" onclick="drawBoardDetail(${i})">Chỉnh sửa</button>
             </td>`;
    }
    result += "</table>";
    container.innerHTML = result;
}

function drawBoardDetail(index) {
    showDetail()
    student = (index !== undefined) ? {
            ten: "",
            ngaySinh: formatDate(new Date("1/1/2001")),
            gioiTinh: "",
            lop: "",
            email: "",
            anh: ""
        }
        : new Student("", formatDate(new Date("1/1/2001")), "", "Class 1", "", "");
    detail.innerHTML = `<table>
        <tr style="background-color: #707071;">
            <th class='none_border' colspan='3''>
                <h1>Thông tin học viên</h1>
            </th>
            <td class="none_border">
                <button id="exit" type="button" onclick="hideDetail()">
                    <img class="icon" id="exit" alt="exit" src="img/exit.png">
                </button>
            </td>
        </tr>
        <tr>
            <th>Mã học viên</th>
            <th colspan='2'>
                <div>
                    <input type='text' value='${index !== undefined ? students[index].msv : student.msv}' disabled>
                    <img class="icon" id="icon" alt='check' src='img/checked.png'>
                </div>
            </th>
            <td rowspan='7'>
                <img id='image' alt='image' src='${index !== undefined ? students[index].anh : ""}'>
            </td>
        </tr> 
        <tr>
            <td>Họ và tên</td>
            <td colspan='2'>
                <div>
                    <input type='text' id='ten' onchange='checkName(student, document.getElementById("icon_check_name"), this)' 
                          value='${index !== undefined ? students[index].ten : ""}'>
                    <img class="icon" id='icon_check_name' alt='check' style='visibility:hidden;' src=''>
                </div>
            </td>
        </tr>
        <tr>
            <td>Ngày sinh</td>
            <td colspan='2'>
                <div>
                    <input type='date' id='ngay_sinh' value='${index !== undefined ? students[index].ngaySinh : student.ngaySinh}'>
                </div>
            </td>
        </tr>
        <tr>
            <td>Giới tính</td>
            <td style='border: none;'>
                <div>
                    <input type='radio' name='gender' value='male' style='width: fit-content'>
                    <label>Nam</label>
                </div>
            </td>
            <td style='border: none;'>
                <div>
                    <input type='radio' name='gender' value='female' style='width: fit-content'>
                    <label>Nữ</label>
                </div>
            </td>
        </tr>
        <tr>
            <td>Lớp</td>
            <td colspan='2'>
                <div>
                    <select id="selectClass">
                        <option value="1">Class 1</option>
                        <option value="2">Class 2</option>
                        <option value="3">Class 3</option>
                        <option value="4">Class 4</option>
                        <option value="5">Class 5</option>
                        <option value="6">Class 6</option>
                    </select>
               </div>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td colspan='2'>
                <div>
                    <input type='text' id='ten' onchange='checkEmail(student, document.getElementById("icon_check_email"), this)' 
                          value='${index !== undefined ? students[index].email : ""}'>
                    <img class="icon" id='icon_check_email' alt='check' style='visibility: hidden;' src=''>
                </div>
            </td>
        </tr>
        <tr>
            <td>Link Ảnh</td>
            <td colspan='2'>
                <input type='file' accept='image/*' id='src_image' onchange='setImage(student, this, document.getElementById("image"))'>
            </td>
        </tr>
        <tr style='justify-content: center;'>
            <td colspan='4' class="none_border">
                <button type='button' id="submit" onclick='addOrEdit(student,${index})'>Thêm hoặc Chỉnh sửa</button>
            </td>
        </tr>
    </table>`;

    let dateTag = document.querySelector("input[type='date']");
    let selectTag = document.querySelector("select");
    let genderTags = document.querySelectorAll('input[name="gender"]');

    if (index !== undefined) {
        //icon check
        showIconCheck(document.getElementById("icon_check_name"), true);
        showIconCheck(document.getElementById("icon_check_email"), true);

        // Gender
        if (students[index].gioiTinh === "Nam") {
            document.querySelector('input[value="male"]').checked = true;
        } else if (students[index].gioiTinh === "Nữ") {
            document.querySelector('input[value="female"]').checked = true;
        }

        // Class
        let myClass = students[index].lop;
        document.querySelector("#selectClass option[value='" + myClass[myClass.length - 1] + "']").selected = true;
    }

    genderTags.forEach(gender => {
        gender.addEventListener("change", () => {
            student.gioiTinh = gender.value === "male" ? "Nam" : "Nữ";
        });
    })

    selectTag.addEventListener("change", () => {
        student.lop = `Class ${selectTag.value}`;
    });

    dateTag.addEventListener("change", () => {
        student.ngaySinh = formatDate(new Date(dateTag.value));
    })
}

//Manage
function addOrEdit(student, index) {
    if (index !== undefined) {
        editStudent(student, index);
    } else {
        if (Object.values(student).some(value => value.toString().trim() === "")) {
            alert("Something Wrong !");
        } else {
            addStudent(student);
        }
    }
}

function addStudent(student) {
    students.push(student);
    alert(`Add student id: ${student.msv} , name: ${student.ten} success`);
    hideDetail()
    drawBoardManager();
}

function editStudent(student, index) {
    students[index].ten = student.ten !== "" ? student.ten : students[index].ten;
    students[index].ngaySinh = student.ngaySinh !== "" ? student.ngaySinh : students[index].ngaySinh;
    students[index].gioiTinh = student.gioiTinh !== "" ? student.gioiTinh : students[index].gioiTinh;
    students[index].email = student.email !== "" ? student.email : students[index].email;
    students[index].lop = student.lop !== "" ? student.lop : students[index].lop;
    students[index].anh = student.anh !== "" ? student.anh : students[index].anh;
    alert(`Edit student id: ${students[index].msv} , name: ${students[index].ten} success`);
    hideDetail()
    drawBoardManager();
}

function removeStudent(index) {
    let isRemove = confirm(`Xóa học sinh ${students[index].msv} : ${students[index].ten}`);
    if (isRemove) {
        students.splice(index, 1);
        drawBoardManager();
    }
}

//Init
function init() {
    students.push(new Student("Nguyễn Văn A", formatDate(new Date("1/1/2001")), "Nam", "Class 3", "nguyenvana@gmail.com", "img/img..png"));
    students.push(new Student("Nguyễn Văn B", formatDate(new Date("1/1/2001")), "Nam", "Class 2", "nguyenvanb@gmail.com", "img/img..png"));
    students.push(new Student("Nguyễn Văn C", formatDate(new Date("1/1/2001")), "Nam", "Class 1", "nguyenvanc@gmail.com", "img/img..png"));
    drawBoardManager();
}

//Check
function checkName(student, icon, tag) {
    let condition = !(tag.value.length > 50 || tag.value.length === 0)
    showIconCheck(icon, condition);
    if (condition) student.ten = tag.value;
}

function checkEmail(student, icon, tag) {
    let value = tag.value.toString().trim();
    let condition = value.includes("@gmail.com")
        && value.indexOf("@gmail.com") === value.length - 10
        && isNaN(parseInt(value[0]));
    showIconCheck(icon, condition);
    if (condition) student.email = tag.value;
}

function setImage(student, tag, image) {
    image.src = URL.createObjectURL(tag.files[0]);
    image.onload = () => {
        if (image.complete && image.naturalWidth > 0) {
            student.anh = URL.createObjectURL(tag.files[0]);
        }
    }

    image.onerror = () => {
        alert("Something Error!");
    }
}

function showIconCheck(icon, condition) {
    icon.style.visibility = "visible";
    if (!condition) {
        icon.src = "img/uncheck.png";
    } else {
        icon.src = "img/checked.png";
    }
}

function newMSV() {
    let arr = students.length !== 0 ? students[students.length - 1].msv.split("-") : ["HV", "0000"];
    let currentIndex = parseInt(arr[1]);
    let newIndex = ++currentIndex;
    let count = 1;
    let max = 4 - newIndex.toString().length
    while (count <= max) {
        newIndex = "0" + newIndex;
        count++;
    }
    return "HV-" + newIndex;
}

function formatDate(date) {
    const yyyy = date.getFullYear();
    const mm = String(date.getMonth() + 1).padStart(2, '0');
    const dd = String(date.getDate()).padStart(2, '0');
    return `${yyyy}-${mm}-${dd}`;
}

function hideDetail() {
    detail.style.display = "none";
}

function showDetail() {
    detail.style.display = "flex";
}
