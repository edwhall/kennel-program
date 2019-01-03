
public class Dog {

    private String name;
    private String breed;
    private int age;
    private int weight;

    public Dog(String name, String breed, int age, int weight){
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public String getBreed(){
        return breed;
    }

    public int getAge(){
        return age;
    }

    public int increaseAge() {
        return age++;
    }

    public int getWeight(){
        return weight;
    }

    public double getTailLength(){
        if(breed.equalsIgnoreCase("Tax") || breed.equalsIgnoreCase("Dachshund")){
            return 3.70;
        } else {
            return (age * weight) / 10.0;
        }


    }

    public String toString(){
        return String.format("Name = %s, Breed = %s, Age = %d years, Weight = %d kg, Tail Length = %.1f",getName(), getBreed(),getAge(), getWeight(), getTailLength());
    }
}
