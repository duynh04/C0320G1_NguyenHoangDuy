function setOfEquations(numbers) {
    let matA = [];
    let invMatA = [];
    let matB = [];
    let detA, temp;
    let result = [];
    let isZero;
    matA = [numbers[0], numbers[1], numbers[3], numbers[4]];
    matB = [numbers[2], numbers[5]];
    //console.log(matB);
    //console.log(matA);
    detA = matA[0] * matA[3] - matA[1] * matA[2];
    console.log("detA:  " + detA)
    isZero = matB.every((value) => {return value == 0;});

    //console.log(isZero);
    if(isZero) {
        if(detA)
            return "Infinity";
        else {
            return "0, 0";
        }
    } else {
        if (detA == 0) {
            if((matA[0] / matA[2] == matA[1] / matA[3]) && (matA[0] / matA[2] == matB[0] / matB[1])) {
                return "Infinity";
            } else {
                return "Cannot solved";
            }
        } else {
            invMatA = invertMaxtrix(matA, detA);
            for(let i = 0; i < 4; i += 2) {
                temp = invMatA[i] * matB[0] + invMatA[i + 1] * matB[1];
                result.push(temp);
            }
            return result.join(",");
        }
    } 
    
}
function invertMaxtrix(mat, det) {
    let tempMat = [mat[3], -mat[1], -mat[2], mat[0]];
    return tempMat.map((value) => { return value / det});

}
