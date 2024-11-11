#include <stdio.h>
int main() {
  double x;
  x = 0;
  x = x;
  x = 0.0 + 0.0;
  printf("%g\n", (double)(0.0 + 0.0));
  return 0;
}
