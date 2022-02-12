package MainPackage;

import java.util.Objects;

public class Animal implements Comparable<Animal>{

    private String name;
    private int population;

    public Animal(String name, int population) {
        this.setName(name);
        this.setPopulation(population);
    }

    public String show() {
        return "Animal: {"
                + "name: " + name + ", "
                + "population: " + population
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return population == animal.population && Objects.equals(name, animal.name);
    }

    @Override
    public int compareTo(Animal o) {
        return this.population - o.population;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }


}
