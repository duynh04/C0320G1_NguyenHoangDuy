function bestFriend(a,b) {
  let maxV;
  let minV;  
  let count = 0;
  let tempArr = [];
  let tempArr1 = [];
  if (b[0] >= b[1]) {
    maxV = b[0];
    minV = b[1];
  } else {
    maxV = b[1];
    minV = b[0];
  }
  a.sort((x, y) => {return x - y});
  console.log(`array a: ${a}`);
  while (a.length > 0) {
    if (minV >= a[0] && maxV >= a[1]) {
      if (a.length < 3) {
        count++;
        break;
      }
        temp = a[0] + a[1]
      for (let j = 2; j < a.length; j++) {
        if (maxV >= a[j]) {
          if (temp < a[0] + a[j]) {
            temp = a[0] + a[j];
          } 
        } else {
          tempArr = a.splice(0, 1);
          tempArr1 = a.splice(j - 2, 1);
          count++;
          console.log(`index j = ${j}`);
          console.log(`element deleted : ${tempArr} and ${tempArr1}`);
          console.log(`a array : ${a}`);
          break;
        }
        if (j == a.length - 1) {
          tempArr = a.splice(0, 1);
          tempArr1 = a.splice(j - 1, 1);
          count++;
          console.log(`index j = ${j}`);
          console.log(`element deleted : ${tempArr} and ${tempArr1}`);
          console.log(`a array : ${a}`);
          break;
        }
      }
    } else {
      count += a.length;
      break;
    }
  }
      console.log("last count " + count)
  return count;
}
