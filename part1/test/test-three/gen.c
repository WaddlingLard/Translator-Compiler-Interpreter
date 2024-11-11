#include <stdio.h>
int main() {
  double x, y, z;
  x = 0;
  x = x;
  x = 1.0 + 1.0;
  printf("%g\n", (double)(1.0 + 1.0));
  y = x + 2.0;
  printf("%g\n", (double)(x + 2.0));
  z = y + x;
  printf("%g\n", (double)(y + x));
  return 0;
}
