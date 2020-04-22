function createRectangle(points){
    let angleUV, angleUZ, angleVZ;
    let vectorU, vectorV, vectorZ;
    vectorU = createVector(points[0], points[1]);
    vectorV = createVector(points[0], points[2]);
    vectorZ = createVector(points[1], points[2]);
    angleUV = findAngle(vectorU, vectorV);
    if (angleUV == 90) {
        return findLastPoint(points[0], points[1], points[2]);
    }
    angleUZ = findAngle(vectorU, vectorZ);
    if (angleUZ == 90) {
        return findLastPoint(points[1], points[0], points[2]);
    }
    angleVZ = findAngle(vectorV, vectorZ);
    if (angleVZ == 90) {
        return findLastPoint(points[2], points[1], points[0]);
    }
    return [];

}
function findLastPoint(p0, p1, p2) {
    let sumX = (p1[0] + p2[0]);
    let sumY = (p1[1] + p2[1]);
    console.log([sumX - p0[0], sumY - p0[1]]);
    return [sumX - p0[0], sumY - p0[1]];
}
function findAngle(v1, v2) {
    let product = v1[0] * v2[0] + v1[1] * v2[1];
    let magV1 = Math.sqrt((v1[0] ** 2 + v1[1] ** 2));
    let magV2 = Math.sqrt((v2[0] ** 2 + v2[1] ** 2));
    let cosAngle = product / magV1 / magV2;
    let angle = Math.acos(cosAngle); // radian
    angle = angle * 180 / Math.PI;
    return angle < 90 ? angle : (180 - angle);  
}
function createVector(point1, point2) {
   return [point1[0] - point2[0], point1[1] - point2[1]]; 
}
