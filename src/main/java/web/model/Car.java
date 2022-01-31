package web.model;

public class Car {
    private String name;
    private int series;
    private String model;

    public Car(String name, int series, String model) {
        this.name = name;
        this.series = series;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
