#include<stdio.h>
#include<stdlib.h>

int partition(int arr[],int si,int ei){
    int pivot=arr[ei];
    int i=si-1;
    for(int j=si;j<ei;j++){
        if(arr[j] <= pivot){
            i++;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
    i++;
    int temp = pivot;
    arr[ei] = arr[i];
    arr[i] = temp;
    return i;
}

void quickSort(int arr[],int si,int ei){
    if(si>=ei){
        return;
    }

    int idx=partition(arr,si,ei);
    quickSort(arr,si,idx-1);
    quickSort(arr,idx+1,ei);
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
    quickSort(arr,0,n);
    printArray(arr,n);
}