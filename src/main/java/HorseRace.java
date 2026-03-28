/**
 * Represents a race between two horses.
 * The race proceeds in rounds until at least one horse reaches the finish line.
 */
public class HorseRace {

    private Horse horse1;
    private Horse horse2;

    /**
     * Creates a HorseRace between two horses.
     */
    public HorseRace(Horse horse1, Horse horse2) {
        this.horse1 = horse1;
        this.horse2 = horse2;
    }

    public Horse getHorse1() {
        return horse1;
    }

    public Horse getHorse2() {
        return horse2;
    }

    /**
     * Runs the race. Each round both horses advance until at least one finishes.
     * Updates win/loss/draw statistics for both horses.
     * @return the winning horse, or null if it is a draw
     */
    public Horse race() {
        horse1.resetPosition();
        horse2.resetPosition();

        int round = 1;

        System.out.println("--- Race Start! Finish line at position 20 ---");

        while (!horse1.hasFinished() && !horse2.hasFinished()) {

            int roll1 = horse1.advance();
            int roll2 = horse2.advance();

            System.out.println("Round " + round + ": " +
                    horse1.getName() + " advances " + roll1 +
                    " -> position: " + horse1.getPosition());

            System.out.println("         " +
                    horse2.getName() + " advances " + roll2 +
                    " -> position: " + horse2.getPosition());

            round++;
        }

        // Determine result
        if (horse1.hasFinished() && horse2.hasFinished()) {
            horse1.recordDraw();
            horse2.recordDraw();
            System.out.println("Result: Draw!");
            return null;
        }
        else if (horse1.hasFinished()) {
            horse1.recordWin();
            horse2.recordLoss();
            System.out.println("Winner: " + horse1.getName());
            return horse1;
        }
        else {
            horse2.recordWin();
            horse1.recordLoss();
            System.out.println("Winner: " + horse2.getName());
            return horse2;
        }
    }
}
