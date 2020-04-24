function findTriangle1(n, arr) {
  let maxEdge = arr[0][0] + arr[0][1];
  let tempValue;
  for (let i = 1; i < n; i++) {
    tempValue = arr[i][0] + arr[i][1];
    if (maxEdge < tempValue) 
      maxEdge = tempValue;
  }
  return maxEdge;
}
