class Bar {
    dx = 10;
    constructor(x, y, w, h, color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }
    create() {
        ctx.beginPath();
        ctx.fillStyle = this.color;
        ctx.rect(this.x, this.y, this.w, this.h);
        ctx.fill();
    }
    moveLeft() {
        ctx.clearRect(this.x, this.y, this.w, this.h);
        this.x -= this.dx;
        this.isHitting();
        this.create();
    }
    moveRight() {
        ctx.clearRect(this.x, this.y, this.w, this.h);
        this.x += this.dx;
        this.isHitting();
        this.create();
    }
    isHitting() {
        // left, right of canvas
        if (this.x < 0 ) { 
            this.x = 0;
        } else if (this.x + this.w >= canvas.width) {
            this.x = canvas.width - this.w;
        }
    }
    
}