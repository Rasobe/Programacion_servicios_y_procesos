#include <stdio.h>
#include <sys/types.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
    pid_t padre, hijo;
    padre = getppid(); // obtener el PID del padre
    hijo = fork(); // obtener el PID del hijo y hacemos dos ramas
    if (hijo == -1) // si sale -1, es un error 
    {
        printf("Error en el fork.");
    } else if (hijo == 0)
    {
        sleep(1);
        kill(padre, SIGUSR1);
    } else {
        pause();
    }
    wait(2);
    
    return 0;
}
