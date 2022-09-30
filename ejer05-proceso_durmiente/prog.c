#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <signal.h>

// creamos un manejador de senyal y luego le damos funciones.
void manejadorSenyal(int numSenyal);

int main(int argc, char const *argv[])
{
    // 
    signal(SIGUSR1, manejadorSenyal);   // estamos vinculando la señal SIGUSR1 con la función, así cuando reciba esta señal, para lo que este haciendo y lanzar lo que tenga definida
    printf("PID: %d\n", getpid());
    sleep(20);    
    return 0;
}

void manejadorSenyal(int numSenyal) {
    printf("He recibido una señal número: %d", numSenyal);  // numSenyal guarda el número
}