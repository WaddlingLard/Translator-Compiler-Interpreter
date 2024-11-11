#include <stdio.h>
int main() {
  double x, y, z;
  x = 0;
  x = x;
  printf("%g\n", (double)(2.0 + 3.0));
  x = 2.0 + 3.0;
  ;
  printf("%g\n", (double)(x + 2.0));
  y = x + 2.0;
  ;
  printf("%g\n", (double)(x + y + 6.0));
  z = x + y + 6.0;
  ;
  return 0;
}
