function soloBingoGame(a, b, search) {
  let indexA;
  let indexB;
  let isMatchA = false;
  let isMatchB = false;
  let xA, yA;
  let xB, yB;
  let checkA;
  let checkB;
  for (let i = 0; i < search.length; i++) {
    isMatchA = false;
    isMatchB = false;
    for (let j = 0; j < a.length; j++) {
      if (!isMatchA) {
        indexA = a[j].indexOf(search[i]); 
        if (indexA != -1) {
          a[j][indexA] = 0;
          xA = j;
          yA = indexA;
          isMatchA = true;
        }
      }
      if (!isMatchB) {
        indexB = b[j].indexOf(search[i]); 
        if (indexB != -1) {
          b[j][indexB] = 0;
          xB = j;
          yB = indexB;
          isMatchB = true;
        }
      }
      if(isMatchA && isMatchB)
        break;
    }
    if (i > 3) {
      checkA = checkWinner(a, xA, yA);
      checkB = checkWinner(b, xB, yB);

      if(checkA && checkB)
        return "Good";
      else if (checkA)
        return "Long";
      else if (checkB)
        return "Phu";
    }
  }
  return "Good";
}
function checkWinner(board, x, y) {
  let bingo = true;
  //scans row
  for(let i = 0; i < 5; i++) {
    if(board[x][i] != 0) {
      bingo = false;
      break;
    } 
  }
  if(bingo) 
    return true;
  bingo = true;
  //scans col
  for(let i = 0; i < 5; i++) {
    if(board[i][y] != 0) {
      bingo = false;
      break;
    }
  }
  if(bingo) 
    return true;
  bingo = true;
  // check cheo
  if(x == y){
    for(let i = 0; i < 5; i++) {
      if(board[i][i] != 0) {
        bingo = false;
        break;
      }
    }
    if(bingo) 
      return true;
    bingo = true;
  }
  if(x - 4 == -y) {
    for(let i = 0; i < 5; i++) {
      if(board[i][ 4 - i] != 0) {
        bingo = false;
        break;
      }
    }
    if(bingo) 
      return true;
  }
  return false;
}
