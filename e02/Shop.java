package exam_xier.e02;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        List<Animal> animalList=new ArrayList<>();
        List<Customer> customerList=new ArrayList<>();

        MyAnimalShop mas=new MyAnimalShop(1000,animalList,customerList,true );


        Customer c1=new Customer("C1",0);
        Customer c2=new Customer("C2",0);
        Customer c3=new Customer("C3",0);
        Customer c4=new Customer("C4",0);
        Customer c5=new Customer("C5",0);
        Customer c6=new Customer("C6",0);
        Customer c7=new Customer("C7",0);
        Customer c8=new Customer("C7",0);
        Customer c9=new Customer("C7",0);
//当顾客不知道要买什么时
        mas.treatCustomer(c1);
        System.out.println("----------");

//当顾客要买的物种卖完或者没有时
        c2.setWantAnimal(new Cat(1,"母"));
//        try {
//            mas.treatCustomer(c2);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("----------");

        //为了下面的测试，这里需要注释

//进货 一岁小母猫
        mas.buyOneAnimal(new Cat(1,"母"));
        mas.seeAnimalList();
        mas.treatCustomer(c2);
        System.out.println("----------");
        System.out.println(mas.getBalance());
        //看一下余额

        mas.seeAnimalList();


        System.out.println("----------");
        //再次进货3只狗，2只一样
        mas.buyOneAnimal(new ChineseRuralDog("田园1",2,"公",true));
        mas.buyOneAnimal(new ChineseRuralDog("田园2",2,"公",true));
        mas.buyOneAnimal(new ChineseRuralDog(1,"母",true));
        mas.seeAnimalList();

        
        System.out.println("----------");
        c3.setWantAnimal(new ChineseRuralDog(2,"公",true));
        mas.treatCustomer(c3);
        //此时买卖猫后1100
        //买三只狗-300，卖狗200，余额正常来说是1000
        System.out.println(mas.getBalance());


        System.out.println("----------");
        //关门
        c4.setWantAnimal(new ChineseRuralDog(1,"母",true));
        mas.closeDoor();


        System.out.println("----------");
        mas.treatCustomer(c4);


        System.out.println("----------");
        //开门
        mas.openDoor();
        //测试卖没有的动物,自定义异常是否正确
        c5.setWantAnimal(new Cat(3,"母"));
        try{
            mas.treatCustomer(c5);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
