class CondicionDeCarrera implements Runnable {
    private static int contador = 0;
    private final SemaforoBinario semaforo;

    public CondicionDeCarrera(SemaforoBinario semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        // inicia semaforo
        semaforo.esperar();
        //

        try {
            contador++;
            System.out.println(Thread.currentThread().getName() + " - 🧮 Contador: " + contador);
        } finally {
            semaforo.liberar();
        }
    }
}
