function isValidGuestPassword(password){
  let diff = [];
  let temp1, temp2;
  // check every string
  for(let i = 0; i < 5; i++) {
    diff[i] = new Array(8);
    if(password.length != 8) {
      return false;
    };
    temp1 = password[i].charCodeAt(0) - password[i].charCodeAt[1];
    if(temp1 == 0) 
      return false;
    diff[i].push(password[i].charCodeAt(0), password[i].charCodeAt[1]);
    for(let j = 2; j < 8; j++) {
      temp2 = password[i].charCodeAt(0) - password[i].charCodeAt[j];
      if(temp2 && temp1 - temp != 0)
        diff[i].push(password[i].charCodeAt(j));
      else
        return false;
    }
    diff[i].sort( (a, b) => {return a - b;});
  }
  // compare others string
  for(let i = 0; i < 8; i++) {
    if(diff[0][i] != diff[1][i]) {

    }
  }
}
