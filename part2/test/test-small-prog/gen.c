#include <stdio.h>
int main() {
  double x;
  x = 0;
  x = x;
  printf("%g\n", (double)(3.0));
  x = 3.0;
  ;
  if (x < 5.0) {
    printf("%g\n", (double)(8.0));
    x = 8.0;
  } else {
    printf("%g\n", (double)(2.0));
    x = 2.0;
  };
  while (x > 5.0) {
    printf("%g\n", (double)(x - 1.0));
    x = x - 1.0;
  };
  return 0;
}
