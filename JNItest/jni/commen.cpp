#include <stdio.h>
int compare(const void *a, const void *b){
	return *((int *)a) - *((int *)b);
}

long getFileSize(FILE *fp){
	fseek(fp, 0L, SEEK_END);
	return ftell(fp);
}
