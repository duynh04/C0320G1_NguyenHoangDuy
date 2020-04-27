function countNumbersBeautiful(a, b) {
  let count1, count2;
  let strA, strB;
  let diff;
  let result;
  if (a > b) return 0;
  strA = a.toString();
  strB = b.toString();
  diff = strB.length - strA.length;
  count1 = findNumber(a);
  count2 = findNumber(b);
  if (diff == 0)
    result = Math.abs(count2[0] - count1[0]);
  else if (diff > 1)
    result = 9 - count1[0] + count2[0] + 9 * (diff - 1);
  else
    result = 9 - count1[0] + count2[0];

  if (count1[1])
    return result + 1;
  return result;
}
function findNumber(num) {
  let strTemp = "";
  let numTemp;
  let str;
  let divResult;
  let mod;
  let result = [0, false];
  str = num.toString();
  for (let i = 0; i < str.length; i++) {
    strTemp += "1";
  }
  numTemp = parseInt(strTemp);
  mod = num % numTemp;
  divResult = Math.floor(num / numTemp);
  if (mod != 0) {
    result[0] = divResult;
    return result;
  } else {
    result[0] = divResult;
    result[1] = true;
    return result;
  }
}
