let inDate, tempDate;
let secondate;
let days;
let arrDate = [];
while (1) {
  inDate = prompt("Input a Date");
  if (checkDate(inDate)) {
    arrDate = inDate.split('/');
    date2 = new Date(arrDate[2], arrDate[1] - 1, arrDate[0]);
    alert(date2);
    alert(printDays(date2) + 1);
    break;
  }
}
function printDays(secondDate) {
  const first = new Date(2020, 0, 1);
  let days = secondDate.getTime() - first.getTime();
  return days / 1000 / 60 / 60 / 24;
}
function checkDate(dates) {
  let temp;
  if (!dates.length) return false;
  let date = dates.split('/');
  if (date.length != 3)
    return false;
  for (let i = 0; i < date.length; i++) {
    temp = parseInt(date[i]);
    if (isNaN(temp))
      return false;
    switch (i) {
      case 0:
        if (temp < 0 || temp > 31) {
          return false
        }
        break;
      case 1:
        if (temp < 0 || temp > 12) {
          return false
        }
        break;
      case 2:
        if (temp < 0) {
          return false
        }
    }
  }
  return true;
}

