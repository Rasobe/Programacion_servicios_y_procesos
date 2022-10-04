#include <unistd.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    
    // execl("/usr/bin/firefox", "firefox", "https://youtube.com", "google.es", NULL); ponemos NULL para decirle de forma forzada que NO HAY MÁS PARAMETROS
    char* v[] = {"firefox", "https://educa.aragon.es", NULL};
    system("ls -l > ls.txt"); // ejecutar un comando del sistema
    execv("/usr/bin/firefox", v);

    return 0;
}
