let inNum;
let regExp = /^\d+$/;
let check;
while (true) {
  inNum = prompt("Input an positive number");
  if (regExp.test(inNum)) {
    inNum = parseInt(inNum);
    break;
  } else {
    alert("The Number is not valid");
  }
}
check = perfectNumber(inNum);
if (check)
  alert(`${inNum} is a perfect number`);
else
  alert(`${inNum} is not a perfect number`);
function perfectNumber(num) {
  let sum = 0;
  for (let i = 1; i <= num / 2; i++) {
    if (num % i === 0)
      sum += i;
  }
  if (sum === num)
    return true;
  return false;
}
