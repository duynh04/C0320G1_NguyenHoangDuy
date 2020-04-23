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
            return "Infinities";
        else {
            return "0, 0";
        }
    } else {
        if (detA == 0) {
            if(matA[0] == 0 && matA[2] == 0){
                check =  (matB[0] * matA[3] == matB[1] * matA[1]);
            }
            else if (matA[1] == 0 && matA[3] == 0) {
                check  = (matB[0] * matA[2] == matB[1] * matA[0]);
            } else {
                check =  (matB[0] * matA[3] == matB[1] * matA[1]);
            }
            if (check) {
                return "Infinities";
            } else {
                return "Can not solve";
            }
        } else {
            invMatA = invertMaxtrix(matA);
            for(let i = 0; i < 4; i += 2) {
                temp = invMatA[i] * matB[0] + invMatA[i + 1] * matB[1];
                temp /= detA;
                result.push(temp);
            }
            return result.join(",");
        }
    } 
    
}
function invertMaxtrix(mat) {
    let tempMat = [mat[3], -mat[1], -mat[2], mat[0]];
    return tempMat;
}
