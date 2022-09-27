#include <stdio.h>      // PRINTF
#include <unistd.h>     // FORK
#include <sys/types.h>  // pid_t
#include <sys/wait.h>   // wait

int main(int argc, char const *argv[])
{
    pid_t numPid;   
    int num = 12;
    numPid = fork();    // con el fork se duplican las ramas del padre
    if (numPid == 0) {  // proceso hijo devolverá cierto y entrará en el if
        printf("Soy el hijo mi pid es: %d\n", getpid());
        num = num  + 3;
        sleep(1);   // el hijo espera un segundo
    } else {
        printf("Soy el padre, mi pid es: %d\n", getpid());
        int estado = 25;
        pid_t pidFinalizado = wait(&estado);   // el & indica que imprime en este caso el 25 EXACTO de la variable. El padre espera a que acabe el hijo cuando ponemos wait(NULL)
        printf("El hijo con PID: %d finalizó con estado%d\n", pidFinalizado, WEXITSTATUS(estado));
        sleep(1);
    }
    printf("Hola, num es: %d\n", num);   
    
    return 0;
}
