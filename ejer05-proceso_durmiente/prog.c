#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <signal.h>

// creamos un manejador de senyal y luego le damos funciones.
void manejadorSenyal(int numSenyal);

int main(int argc, char const *argv[])
{
    // 
    signal(SIGUSR1, manejadorSenyal);  // estamos vinculando la señal SIGUSR1 con la función, así cuando reciba esta señal, para lo que este haciendo y lanzar lo que tenga definida
    signal(SIGUSR2, manejadorSenyal); // cuando me llegue esa señal, ejecuto el manejador de señales.
    printf("PID: %d\n", getpid());
    // sleep(20); tiempo para poner en consola kill y el nombre del proceso
    pause(); // suspende el proceso indefinidamente hasta que le llega una señal
    return 0;
}

void manejadorSenyal(int numSenyal) {
    printf("He recibido una señal número: %d\n", numSenyal);  // numSenyal guarda el número
}