package project.classes;

public class Edition {
    private String name;
    private int numberOfPages;
    private int pageSize;
    private double pricePerPage;
    public Edition(String name, int numberOfPages, int pageSize, double pricePerPage) {
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.pageSize = pageSize;
        this.pricePerPage = pricePerPage;
    }
    public String getName() {
        return name;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public int getPageSize() {
        return pageSize;
    }
    public double getPricePerPage() {
        return pricePerPage;
    }
}
