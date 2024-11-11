#include <stdio.h>
int main() {
  double x;
  x = 0;
  x = x;
  scanf("%lf", &x);
  ;
  if (x > 3.0) {
    if (x == 5.0) {
      printf("%g\n", (double)(x + 5.0));
      x = x + 5.0;
    } else {
      printf("%g\n", (double)(x + 6.0));
      x = x + 6.0;
    }
  } else {
    printf("%g\n", (double)(x - 1.0));
    x = x - 1.0;
  };
  while (x > 3.0) {
    printf("%g\n", (double)(x - 1.0));
    x = x - 1.0;
  };
  ;
  return 0;
}
