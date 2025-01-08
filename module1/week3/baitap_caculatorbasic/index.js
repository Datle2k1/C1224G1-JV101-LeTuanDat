console.log('Happy developing ✨')
let lastResult = ""
let containOperator = false

let btn1 = document.getElementById('btn1');
btn1.addEventListener('click', function () {
    handleNumber("1")
})
let btn2 = document.getElementById('btn2');
btn2.addEventListener('click', function () {
    handleNumber("2")
})
let btn3 = document.getElementById('btn3');
btn3.addEventListener('click', function () {
    handleNumber("3")
})
let btn4 = document.getElementById('btn4');
btn4.addEventListener('click', function () {
    handleNumber("4")
})
let btn5 = document.getElementById('btn5');
btn5.addEventListener('click', function () {
    handleNumber("5")
})
let btn6 = document.getElementById('btn6');
btn6.addEventListener('click', function () {
    handleNumber("6")
})
let btn7 = document.getElementById('btn7');
btn7.addEventListener('click', function () {
    handleNumber("7")
})
let btn8 = document.getElementById('btn8');
btn8.addEventListener('click', function () {
    handleNumber("8")
})
let btn9 = document.getElementById('btn9');
btn9.addEventListener('click', function () {
    handleNumber("9")
})
let btn0 = document.getElementById('btn0');
btn0.addEventListener('click', function () {
    handleNumber("0")
})

let add = document.getElementById('add');
add.addEventListener('click', () => {
    addOperator("+")
})
let sub = document.getElementById('sub');
sub.addEventListener('click', () => {
    addOperator("-")
})
let multi = document.getElementById('multi');
multi.addEventListener('click', () => {
    addOperator("x")
})
let divide = document.getElementById('divide');
divide.addEventListener('click', () => {
    addOperator("/")
})

let btnReset = document.getElementById('reset');
btnReset.addEventListener('click', () => {
    display.innerHTML = "0"
})
let btnEqual = document.getElementById('equal');
btnEqual.addEventListener('click', () => {
    getResult()
})

let display = document.getElementById('display');

function addOperator(operator) {
    if (!containOperator) {
        switch (operator) {
            case "+":
                display.innerHTML += "+";
                break;
            case "-":
                display.innerHTML += "-";
                break;
            case "x":
                display.innerHTML += "x";
                break;
            case "/":
                display.innerHTML += "/";
                break;
        }
        containOperator = true;
    }
}

function handleNumber(number) {
    let value = display.innerHTML
    let length = display.innerHTML.length
    if (length === 1 && value === "0") {
        display.innerHTML = "";
        addNumber(number)
    } else {
        addNumber(number)
    }
}

function addNumber(number) {
    switch (number) {
        case "1":
            display.innerHTML += "1";
            break;
        case "2":
            display.innerHTML += "2";
            break;
        case "3":
            display.innerHTML += "3";
            break;
        case "4":
            display.innerHTML += "4";
            break;
        case "5":
            display.innerHTML += "5";
            break;
        case "6":
            display.innerHTML += "6";
            break;
        case "7":
            display.innerHTML += "7";
            break;
        case "8":
            display.innerHTML += "8";
            break;
        case "9":
            display.innerHTML += "9";
            break;
        case "0":
            display.innerHTML += "0";
            break;
    }
}

function getResult() {
    console.log(containOperator)
    let ipt = display.innerHTML;
    let ar = ipt.split("");
    let operator = ""
    let num1, num2;
    if (containOperator) {
        for (let i = 0; i < ar.length; i++) {
            if (isNaN(parseInt(ar[i]))) {
                operator = ar[i];
                num1 = parseInt(ipt.substr(0, i));
                num2 = parseInt(ipt.substr(i + 1));
                break;
            }
        }
    }
    switch (operator) {
        case "+":
            display.innerHTML = `${num1 + num2}`;
            break;
        case "-":
            display.innerHTML = `${num1 - num2}`;
            break;
        case "x":
            display.innerHTML = `${num1 * num2}`;
            break;
        case "/":
            if (num2 !== 0) {
                display.innerHTML = `${num1 / num2}`;
            } else  {
                display.innerHTML = ""
            }
            break;
    }
    containOperator = false
    lastResult = display.innerHTML;
}
