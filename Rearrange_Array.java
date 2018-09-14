/*
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Lets say N = size of the array. Then, following holds true :
All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer

Input : [1, 0]
Return : [0, 1]

*/

void rearrange(int arr[], int n)  
    { 
        // First step: Increase all values by (arr[arr[i]]%n)*n 
        for (int i = 0; i < n; i++) 
            arr[i] += (arr[arr[i]] % n) * n; 
  
        // Second Step: Divide all values by n 
        for (int i = 0; i < n; i++) 
            arr[i] /= n; 
    } 
