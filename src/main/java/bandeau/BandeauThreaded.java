package bandeau;

public class BandeauThreaded {
    private Bandeau bandeau;
    private Scenario scenario;
    private Thread thread;

    public BandeauThreaded(Bandeau bandeau, Scenario scenario) {
        this.bandeau = bandeau;
        this.scenario = scenario;
        this.thread = new Thread(this::runScenario);
    }

    public void startScenario() {
        if (!thread.isAlive()) {
            thread.start();
        }
    }

    private void runScenario() {
        synchronized (bandeau) {
            scenario.playOn(bandeau);
        }
    }

    public Thread getThread() {
        return this.thread;
    }
}
