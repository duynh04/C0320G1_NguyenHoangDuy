function cleanMachine(n, m, x, y) {
  let d = 1;
  let count = 1;
  while (true) {
    if (x + d > n) {
      count += n - x;
      break;
    } else x += d;
    count += d;

    if (y - d < 1) {
      count += y - 1;
      break;
    } else y -= d;
    count += d;
    d++;
    if (x - d < 1) {
      count += x - 1;
      break;
    } else x -= d;
    count += d;

    if (y + d > m) {
      count += m - y;
      break;
    } else y += d;
    count += d;
    d++;
  }
  return count;
}
