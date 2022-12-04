package exam_xier.e02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyAnimalShop implements AnimalShop {

    double inTake;
    double expense;
    double balance;

    public MyAnimalShop() {
    }

    public MyAnimalShop(double balance, List<Animal> animalList, List<Customer> customerList, boolean ifOpen) {
        this.balance = balance;
        this.animalList = animalList;
        this.customerList = customerList;
        this.ifOpen = ifOpen;
    }

    List<Animal> animalList = new ArrayList<>();

    List<Customer> customerList = new ArrayList<>();

    boolean ifOpen = true;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void buyOneAnimal(Animal a) throws InsufficientBalanceException {
        if (a.price > balance) {
            throw new InsufficientBalanceException("钱不够啊，充钱");
        } else {
            System.out.println("我的店铺成功购买一只小动物");
            balance -= a.price;
            animalList.add(a);
            expense += a.price;
        }
    }

    @Override
    public void treatCustomer(Customer c) throws AnimalNotFoundException {
        customerList.add(c);
        c.times++;
        c.latestTime = LocalDate.now();

        //迎合顾客买动物的需求
        //挑选动物
        if (ifOpen) {
            if (c.getWantAnimal() != null) {
                //判断有没有
                if (!animalList.contains(c.getWantAnimal())) {
                    throw new AnimalNotFoundException("本店该种动物已经卖完了");
                } else {
                    //判断有的话有几只，有一只直接卖，多只就进行挑选
                    if (findSameAni(animalList, c.getWantAnimal()).size() != 1) {
                        int i = 1;
                        //符合要求的打印出来
                        for (Animal animal : findSameAni(animalList, c.getWantAnimal())) {
                            System.out.println(i + ": " + animal);
                            ++i;
                        }
                        System.out.println("请挑选，输入序号");
                        System.out.println("按-1可退出不买");
                        //进行挑选
                        int select = sc.nextInt();
                        while (select > findSameAni(animalList, c.getWantAnimal()).size()) {
                            System.out.println("请挑选，输入序号");
                            select = sc.nextInt();
                            if (select <= findSameAni(animalList, c.getWantAnimal()).size() | select == -1) {
                                break;
                            }
                        }
                        if (select != -1)
                            System.out.println(c + "成功买走想要的动物" + findSameAni(animalList, c.getWantAnimal()).get(select - 1));
                        else return;
                    } else {
                        System.out.println(c + "成功买走想要的动物" + c.getWantAnimal());
                    }
                    balance += (c.getWantAnimal().price + 100);
                    animalList.remove(c.getWantAnimal());
                    inTake += (c.getWantAnimal().price + 100);
                    c.setWantAnimal(null);
                }
            } else {
                System.out.println("请确认顾客" + c.name + "想要买什么动物");
            }
        }
        else System.out.println("本店休息，下次再来");
    }




    public void closeDoor(){
        for(Customer c:customerList){
            System.out.println(c.toString());
        }
        System.out.println("今天总账:"+"\n"+ "收入:"+inTake+"\n"
                +"支出:"+expense+"\n"+"利润"+(inTake-expense));
        ifOpen=false;
    }

    public void openDoor(){
        this.ifOpen=true;
        System.out.println("开门了");
    }

    //寻找店内符合要求的有多少只
    public static List<Animal> findSameAni(List<Animal> animalList,Animal targetAnimal) {
        List<Animal> list = new ArrayList<>();
        for (Animal animal : animalList) {
            if (targetAnimal.equals(animal)) {
                list.add(animal);
            }
        }
        return list;
    }

    //看动物列表情况
    public  void seeAnimalList() {
        if(this.animalList.isEmpty()) System.out.println("没有动物了");
        else {
            for (Animal l : this.animalList) {
                System.out.println(l.toString());
            }
        }
    }

    //看顾客列表情况
    public  void seeCustomerList() {
        if (this.customerList.isEmpty()) System.out.println("从来就没人来过");
        else {
            for (Customer c : this.customerList) {
                System.out.println(c.toString());
            }
        }
    }


}
