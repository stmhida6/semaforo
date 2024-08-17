public class Main {
    public static void main(String[] args) {
        Recurso recurso1 = new Recurso("Recurso 1");
        Recurso recurso2 = new Recurso("Recurso 2");
        SemaforoBinario semaforo = new SemaforoBinario();

        // Crear hilos paras interbloqueo
        Thread hilo1 = new Thread(new Interbloqueo(recurso1, recurso2, semaforo), "Hilo 1");
        Thread hilo2 = new Thread(new Interbloqueo(recurso2, recurso1, semaforo), "Hilo 2");

        // Crear hilos para  condición de carrera
        Thread hilo3 = new Thread(new CondicionDeCarrera(semaforo), "Hilo 3");
        Thread hilo4 = new Thread(new CondicionDeCarrera(semaforo), "Hilo 4");

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        // Esperar a que los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
