#include <stdio.h>
int main() {
  double x;
  x = 0;
  x = x;
  printf("%g\n", (double)(2.0));
  x = 2.0;
  ;
  while (x < 5.0) {
    printf("%g\n", (double)(x + 1.0));
    x = x + 1.0;
  };
  return 0;
}
