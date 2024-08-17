class SemaforoBinario {
    private boolean disponible = true;
    // si esta disponible, se puede usar el recurso

    public synchronized void esperar() {
        // si no esta disponible, se espera
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        disponible = false;
    }

    public synchronized void liberar() {
        // se libera el recurso y se notifica a los hilos en espera
        disponible = true;
        notify();
    }
}
