#include<stdio.h>
#include<cuda.h>

__global__ void arrmul(int *x,int *y, int *z)    //kernel definition
{
  int id=blockIdx.x; 
/* blockIdx.x gives the respective block id which starts from 0 */
  z[id]=x[id]*y[id];
}

int main()
{
    int a[6]={10,20,30,40,50,60};
    int b[6]={1,2,3,4,5,6};
    int c[6];
    int *d,*e,*f;
    int i;
 
/* cudaMalloc() allocates memory from Global memory on GPU */ 
    cudaMalloc((void **)&d,6*sizeof(int)); 
    cudaMalloc((void **)&e,6*sizeof(int));
    cudaMalloc((void **)&f,6*sizeof(int));

/* cudaMemcpy() copies the contents from destination to source. Here destination is GPU(d,e) and source is CPU(a,b) */ 
 cudaMemcpy(d,a,6*sizeof(int),cudaMemcpyHostToDevice);    
 cudaMemcpy(e,b,6*sizeof(int),cudaMemcpyHostToDevice); 
 
/* call to kernel. Here 6 is number of blocks, 1 is the number of threads per block and d,e,f are the arguments */  
arrmul<<<6,1>>>(d,e,f); 

/* Here we are copying content from GPU(Device) to CPU(Host) */
 cudaMemcpy(c,f,6*sizeof(int),cudaMemcpyDeviceToHost); 
    
printf("\Dot Product of two arrays:\n ");
    for(i=0;i<6;i++)
    {
        printf("%d\t",c[i]);
    }

/* Free the memory allocated to pointers d,e,f */ 
    cudaFree(d); 
    cudaFree(e);
    cudaFree(f);
    return 0;
}
