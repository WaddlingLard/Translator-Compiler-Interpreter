#include <stdio.h>
int main() {
  double x, y, z;
  x = 0;
  x = x;
  printf("%g\n", (double)(1.0 + 1.0));
  x = 1.0 + 1.0;
  ;
  printf("%g\n", (double)(x + 2.0));
  y = x + 2.0;
  ;
  printf("%g\n", (double)(y + x));
  z = y + x;
  ;
  return 0;
}
