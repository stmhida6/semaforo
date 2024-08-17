class Interbloqueo implements Runnable {
    private Recurso recurso1;
    private Recurso recurso2;
    private SemaforoBinario semaforo;

    public Interbloqueo(Recurso recurso1, Recurso recurso2, SemaforoBinario semaforo) {
        this.recurso1 = recurso1;
        this.recurso2 = recurso2;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        semaforo.esperar();
        // iniciasemaforo
        try {
            synchronized (recurso1) {
                System.out.println(Thread.currentThread().getName() + " adquirio el recurso1");
                Thread.sleep(1000);  // Simula el tiempu de uso del reurso
                synchronized (recurso2) {
                    System.out.println(Thread.currentThread().getName() + " adquirio el recurso2");

                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        } finally {
            semaforo.liberar();
        }
    }
}
