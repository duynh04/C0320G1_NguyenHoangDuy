class Ball {
    diameter = 0;
    constructor(x, y, radius, color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.isStop = false;
        this.dx = 1;
        this.dy = 1;
        
    }
    create() {
        ctx.beginPath();
        ctx.fillStyle = this.color;
        ctx.arc(this.x, this.y, this.radius, 0, 2 * Math.PI);
        ctx.fill();
        this.diameter = 2 * this.radius; 
    }
    move() {
        if(this.isStop) 
            return;
        ctx.clearRect(this.x - this.radius, this.y - this.radius, this.diameter, this.diameter);
        this.x += this.dx;
        this.y += this.dy;
        this.isHitting();
        this.create();
    }
    isHitting() {
        // left, right of canvas
        if (this.x - this.radius < 0 || this.x + this.radius >= canvas.width) {
            this.dx *= -1;
        } 
        if (this.y - this.radius < 0) {
            this.dy *= -1;
        }
        if (this.y + this.radius >= canvas.height) {
            alert("Game Over");
            this.isStop = true;
        }
    }
    isHitBar(bar) { 
        let fromX = bar.x - this.diameter;
        let toX = bar.x + bar.w + this.diameter; 
        let fromY = bar.y - this.diameter;
        let toY = bar.y + bar.h + this.diameter;
        // top touching
        if(this.y + this.radius == bar.y && (this.x >= fromX && this.x + this.radius <= toX)) {
            this.dy *= -1;
        }
        // left-right touching;
        if (this.x + this.radius == bar.x && (this.y >= fromY && this.y + this.radius <= toY)) {
            this.dx *= -1;
        }
        if (this.x - this.radius == bar.x + bar.w && (this.y >= fromY && this.y + this.radius <= toY)) {
            this.dx *= -1;
        }
    }
}