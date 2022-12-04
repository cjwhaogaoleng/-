package exam_xier.e02;

public class ChineseRuralDog extends Animal{
    boolean sVaccineInjected;

    boolean isHandsome;

    public ChineseRuralDog(){
        super();
        this.price=100;
    };

    public ChineseRuralDog(String name, int age, String sex,  boolean sVaccineInjected) {
        super(name, age, sex, 100);
        this.sVaccineInjected = sVaccineInjected;
    }

    public ChineseRuralDog(int age,String sex,boolean sVaccineInjected){
        super(age,sex,100);
        this.sVaccineInjected=sVaccineInjected;
    }


    //判断小狗长得好不好看，好看价格加倍
    public ChineseRuralDog(String name, int age, String sex,  boolean sVaccineInjected,boolean isHandsome) {
        super(name, age, sex, 100);
        if(isHandsome)super.price=200;
        this.sVaccineInjected = sVaccineInjected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ChineseRuralDog that = (ChineseRuralDog) o;

        return isHandsome == that.isHandsome;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isHandsome ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChineseRuralDog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", price=" + price +
                ", sVaccineInjected=" + sVaccineInjected +
                ", isHandsome=" + isHandsome +
                '}';
    }
}
