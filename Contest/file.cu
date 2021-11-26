#include<stdio.h>
#include<iostream>
#include<cuda.h>
#include<cuda_runtime.h>
#define N 1024
#define threadsPerBlock 512

__global__ void gpu_dot(float *d_a, float *d_b, float *d_c) 
{
  //Define Shared Memory
  __shared__ float partial_sum[threadsPerBlock];
  int tid = threadIdx.x + blockIdx.x * blockDim.x;
  int index = threadIdx.x;
  float sum = 0;
  while (tid < N) 
  {
    sum += d_a[tid] * d_b[tid];
    tid += blockDim.x * gridDim.x;
  }
  // set the partial sum in shared memory
  partial_sum[index] = sum;
  // synchronize threads in this block
  __syncthreads();
  //Calculate Patial sum for a current block using data in shared memory
        int i = blockDim.x / 2;
  while (i != 0) {
    if (index < i)
      {partial_sum[index] += partial_sum[index + i];}
    __syncthreads();
    i /= 2;
  }
  //Store result of partial sum for a block in global memory
  if (index == 0)
    d_c[blockIdx.x] = partial_sum[0];

}
