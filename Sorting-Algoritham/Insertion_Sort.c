#include<stdio.h>
#include<stdlib.h>

void insetionSort(int arr[],int n){
    for(int i=1;i<n;i++){
        int curr=arr[i];
        int prev=i-1;
        while(prev>=0 && arr[prev] > curr){
            arr[prev+1] = arr[prev];
            prev--;
        }
        arr[prev+ 1] = curr;
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
    insetionSort(arr,n);
    printArray(arr,n);
}