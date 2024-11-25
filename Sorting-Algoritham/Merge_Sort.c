#include<stdio.h>
#include<stdlib.h>

void merge(int arr[],int mid,int low,int high){

    int i,j,k,temp[100];

    i=low;
    j=mid+1;
    k=low;
    while(i <=mid && j <= high){
        if(arr[i] < arr[j]){
            temp[k]=arr[i];
            i++;
        }
        else{
            temp[k]=arr[j];
            j++;
        }
        k++;
    }
    while(i <= mid){
        temp[k]=arr[i];
        i++;
        k++;
    }
    while(j <= high){
        temp[k]=arr[j];
        j++;
        k++;
    }
    for(int i=low;i<=high;i++){
        arr[i]=temp[i];
    }
}

void mergeSort(int arr[],int low,int high){
    if(low<high){
        int mid=(low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,mid,low,high);
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
    mergeSort(arr,0,n);
    printArray(arr,n);
}