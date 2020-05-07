let n;
let arr = [];
let ele;
let check;
let i = 0;
let sum, average, divideThree;
let regExp = /^\d+$/;
while (true) {
  n = prompt("Input an Number of element in Array");
  if (n > 0 && n <= 50) {
    if (regExp.test(n)) {
      while (i < n) {
        ele = parseInt(prompt("Input elements"));
        if (isNaN(ele))
          alert("this element is not a number");
        else {
          arr.push(ele);
          i++;
        }
      }
      alert(arr);
      break;
    } else {
      alert("The Number is not valid");
    }
  } else {
    alert(`Length of array must be between 0 and 50`)
  }
}
divideThree = arr.filter(val => val % 3 == 0);
if (divideThree.length != 0) {
  sum = divideThree.reduce((num, val) => num + val);
  average = sum / divideThree.length;
  alert(average);
}

