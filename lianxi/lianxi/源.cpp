#include <stdio.h>
int a, b, temp;
//辗转相除法实现 
int Division(){
	printf("请输入两个数(a,b)：\n");
	scanf("%d,%d", &a, &b);
	if (a < b){
		temp = a;
		a = b;
		b = temp;

	}
	while (a%b != 0){
		temp = a%b;
		a = b;
		b = temp;
	}
	printf("最大公约数为：%d\n", b);
	return 0;
}