package project.classes;

public class Machine {
    private int maximumPaperCapacity;
    private int remainingPaper;
    public Machine(int maximumPaperCapacity) {
        this.maximumPaperCapacity = maximumPaperCapacity;
        this.remainingPaper = 0;
    }
    public int getMaximumPaperCapacity() {
        return maximumPaperCapacity;
    }
    public int getRemainingPaper() {
        return remainingPaper;
    }
    public void loadPaper(int numberOfSheets) {
        this.remainingPaper += numberOfSheets;
    }
    public void printEdition(Edition edition) throws Exception {
        // Check if there is enough paper to print the edition.
        if (this.remainingPaper < edition.getNumberOfPages()) {
            throw new Exception("Not enough paper to print edition " + edition.getName());
        }
        // Print the edition.
        this.remainingPaper -= edition.getNumberOfPages();
    }
}