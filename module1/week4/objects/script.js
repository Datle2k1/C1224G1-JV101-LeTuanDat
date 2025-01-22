/**
 * Created by nhatnk on 4/26/17.
 */

function Hero(image, top, left, size, speed) {
    this.image = image;
    this.top = top;
    this.left = left;
    this.size = size;
    this.speed = speed;

    this.getHeroElement = function () {
        return '<img width="' + this.size + '"' +
            ' height="' + this.size + '"' +
            ' src="' + this.image + '"' +
            ' style="top: ' + this.top + 'px; left:' + this.left + 'px;position:absolute;" />';
    }

    this.setSpeed = function (speed) {
        this.speed = speed;
    }

    this.moveRight = function () {
        this.left += this.speed;
        console.log('ok: ' + this.left);
    }
    this.moveLeft = function () {
        this.left -= this.speed;
        console.log('ok: ' + this.left);
    }
    this.moveTop = function () {
        this.top -= this.speed;
        console.log('ok: ' + this.top);
    }
    this.moveBottom = function () {
        this.top += this.speed;
        console.log('ok: ' + this.top);
    }
}

var hero = new Hero('cat.png', 20, 30, 200, 20);
document.addEventListener("keydown", (event) => {
    if (event.key === 'w') {
        hero.setSpeed(hero.speed+=10);
    }
    if (event.key === 's') {
        hero.setSpeed(hero.speed-=10);
    }
});

function start() {
    let way = Math.floor(Math.random() * 4) + 1;
    switch (way) {
        case 1:
            hero.moveLeft();
            console.log("==> left");
            break;
        case 2:
            hero.moveRight();
            console.log("==> Right");
            break;
        case 3:
            hero.moveTop();
            console.log("==> Top");
            break;
        case 4:
            hero.moveBottom();
            console.log("==> Bottom");
            break;
    }
    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 1000);
}

start();