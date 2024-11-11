#include <stdio.h>
int main() {
  double x;
  x = 0;
  x = x;
  if (3.0 > 5.0) {
    printf("%g\n", (double)(2.0 + 3.0));
    x = 2.0 + 3.0;
  } else {
    printf("%g\n", (double)(5.0 + 2.0));
    x = 5.0 + 2.0;
  };
  return 0;
}
