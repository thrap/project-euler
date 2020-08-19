public class Problem258 {
/**
 * Gjorde denne i mathematica 
 * 
n = 2000;
M = Table[0, {i, n}, {j, n}];
x = Table[1, {i, n}];
Do[M[[i, i + 1]] = 1, {i, n - 1}];
M[[n, 1]] = 1;
M[[n, 2]] = 1;
Print[1];
M10 = Mod[MatrixPower[M, 10], 20092010];

Do[
  Print[i];
  temp = M10;
  M10 = Mod[MatrixPower[temp, 10], 20092010];
  res = Mod[M10.x, 20092010];
  Print[res[[1 ;; 10]]];, {i, 18 - 1}];

 */
}
