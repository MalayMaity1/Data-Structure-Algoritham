#include<stdio.h>
#include<stdlib.h>

void selectionSort(int arr[],int n){
    for(int i=0;i<n-1;i++){
        int loc=i;
        for(int j=i+1;j<n;j++){
            if(arr[j] < arr[loc]){
                loc=j;
            }
        }
        if(i != loc){
            int temp=arr[i];
            arr[i]=arr[loc];
            arr[loc]=temp;
        }
    }
}

void printArray(int arr[],int n){
    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }
    printf("\n");
}
int main(){
    int n;
    printf("Enter the size of the Array : ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter the values in the Array : ");
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    selectionSort(arr,n);
    printArray(arr,n);
}