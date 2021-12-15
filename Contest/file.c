#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>
int main(int argc, char **argv)
{
    int sum, finsum;
    MPI_Init(NULL, NULL);
    int world_rank;
    MPI_Comm_rank(MPI_COMM_WORLD, &world_rank);
    // Storing Number of processes in the communicator world
    int world_size;
    MPI_Comm_size(MPI_COMM_WORLD, &world_size);
    int numbers[world_size];
    if (world_rank == 0)
    {
        for(int i = 1; i<world_size; i++)
        {
            MPI_Recv(&numbers[i], 1, MPI_INT, i, i, MPI_COMM_WORLD);
        }
        int ec = 0, oc =0 ;
        for(int i = 0;i<world_size;i++)
        {
            if(numbers[i]%2==0)ec++;
            else oc++;
        }
        
    }
    else
    {
        int num = rand();
        MPI_Send(&num, 1, MPI_INT, 0, i, MPI_COMM_WORLD,
             MPI_STATUS_IGNORE);
    }


    MPI_Reduce(&num, &finsum, 1, MPI_INT, MPI_DOUBLE, 0, MPI_COMM_WORLD);
    
    if (world_rank == 0)
        printf("\n Average is %.15f\n\n", (finsum/world_size));
    MPI_Finalize();
