#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>
#define ceil(x) (x+y-1)/y
int main(void) {
	int n, k;
	long long int s = 0;;
	int arr[51];
	scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
	scanf("%d", &k);
	for (int i = 0; i < n; i++) s += (arr[i] + k - 1) / k; // ceil((float)arr[i] / k);
	printf("%lld", s*(long long int)k);
	return 0;
}
