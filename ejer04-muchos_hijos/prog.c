#define N_HIJOS 150   // generar una constante
// si no me acuerdo de que librerías poner, pongo en la terminal 'man -a printf' por ejemplo
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
    for (int i = 0; i < N_HIJOS; i++)
    {
        if (fork() == 0)
        {   // codigo de los hijos
            printf("Hola soy el hijo número: %d\n", getpid());
            sleep(1);
            return i;   // para forzar que los hijos no hagan más cosas a parte del if
        }
        
    }

    int estado;
    int pidHIjo;
    for (int i = 0; i < N_HIJOS; i++)
    {
        pidHIjo = wait(&estado);
        printf("El hijo %d ha finalizado con valor de retorno %d\n", pidHIjo, WEXITSTATUS(estado));
    }
    
    
    
    return 0;
}
