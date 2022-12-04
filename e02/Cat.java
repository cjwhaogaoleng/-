package exam_xier.e02;

public class Cat extends Animal{

    boolean isCute;

    public Cat(){
        super();
        price=200;
    }

    public Cat(String name, int age, String sex) {
        super(name, age, sex, 200);
    }

    public Cat(int age, String sex) {
        super( age, sex, 200);
    }
    //判断长得可不可爱，可爱价钱加倍
    public Cat(String name, int age, String sex, boolean isCute) {
        super(name, age, sex, 200);
        this.isCute = isCute;
        if (isCute) price=400;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cat cat = (Cat) o;

        return isCute == cat.isCute;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isCute ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", price=" + price +
                ", isCute=" + isCute +
                '}';
    }
}
