package exam_xier.e02;

public abstract class Animal{
    protected String name;
    protected int age;
    protected String sex;
    protected double price;

    public Animal(){}

    public Animal(String name, int age, String sex, double price) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.price = price;
    }

    //用于顾客购买时，不知道名字，按照需求找符合的动物
    public Animal(int age, String sex, double price) {
        this.age = age;
        this.sex = sex;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age) return false;
        return sex.equals(animal.sex);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + sex.hashCode();
        return result;
    }
}
