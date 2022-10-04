#include <stdio.h>
#include <sys/types.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>

void tratarSeñal(int senyal);

int main(int argc, char const *argv[])
{
    pid_t p;

    p = fork();

    if (p == 0)
    {
        // Soy el hijo
        printf("[HIJO]: En 1 seg. le envío una señal al padre.\n");
        sleep(1);
        kill(getppid(), SIGUSR1);
        printf("[HIJO]: Señal enviada, en un segundo terminaré.\n");
        sleep(1);
    } 
    else 
    {
        // Soy el padre
        signal(SIGUSR1, tratarSeñal); // vincular señal
        printf("[PADRE]: Me quedo esperando señal del hijo.\n");
        pause();
        int estado;
        printf("[PADRE]: Me quedo esperando la finalización del hijo.\n");
        p = wait(&estado); // espero a un hijo, y luego devuelvo ese valor, y luego rellena la variable estado con valores de como ha ido la ejecución
        printf("[PADRE]: El hijo %d ha terminado con estado %d\n", p, WEXITSTATUS(estado)); // obtiene el estado de salida de un proceso hijo.
    }
    

    return 0;
}

void tratarSeñal(int codSenyal){
    printf("[PADRE]: He recibido una señal.\n");
}
