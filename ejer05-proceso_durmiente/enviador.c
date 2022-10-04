#include <stdio.h>
#include <signal.h>
#include <sys/types.h>
#include <stdlib.h> // librería para usar 'atoi', que sirve para pasar de cadena de carácteres a int.

int main(int argc, char const *argv[])
{
    if (argc != 2) // comprobamos si ne consola hay un argumento después de ejecutar el programa (p.j. ./enviador.exe 512333)
    {
        fprintf(stderr, "Error, el programa debe tener un parámetro.\n\n"); // muestra un mensaje de error 
        fprintf(stdout, "Uso del programa: \n\t %s <num_pid>\n\n", argv[0]);
        exit(-1); // salir del programa
    }

    pid_t pidParametro = atoi(argv[1]);
    kill(pidParametro, SIGUSR1); // pasamos el parámetro y después pasamos la señal

    return 0;
}
