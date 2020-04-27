function isValidGuestPassword(password) {
  let diff = [];
  let check;
  let u = 1;
  let v = 0;
  // changto Number Code
  let newPass = changeToNumber(password);
  if (newPass.length == 0) return false;
  // check every string
  for (let i = 0; i < newPass.length; i++) {
    for (let j = 0; j < newPass[i].length - 1; j++) {
      diff = searchMatch(newPass[i][j], newPass[i], j + 1, newPass.length - 1);
      if (diff != -1) return false;
    }
  }
  while (v < 4) {
    if (newPass[v][0] != newPass[u][0]) {
      if (++u > 4) {
        v++;
        u = v + 1;
      }
      continue;
    }
    check = true;
    for (let j = 1; j < 8; j++) {
      if (newPass[v][j] != newPass[u][j]) {
        check = false;
        break;
      }
    }
    if (check) return false;
    if (++u > 4) {
      v++;
      u = v + 1;
    }
  }
  return true;
}
function searchMatch(val, arr, left, right) {
  let mid;
  while (left <= right) {
    mid = Math.floor((left + right) / 2);
    if (val == arr[mid]) return mid;
    else if (val > arr[mid]) left = mid + 1;
    else right = mid - 1;
  }
  return -1;
}

function changeToNumber(password) {
  let newPassWord = [];
  for (let i = 0; i < password.length; i++) {
    newPassWord.push(new Array(8));
    for (let j = 0; j < password[i].length; j++) {
      if (password[i].length != 8) return [];
      newPassWord[i][j] = password[i].charCodeAt(j);
    }
    newPassWord[i].sort((a, b) => {
      return a - b;
    });
  }
  return newPassWord;
}
