package exam_xier.e02;

public interface AnimalShop {
    void buyOneAnimal(Animal a) throws InsufficientBalanceException;

    void treatCustomer(Customer c)throws AnimalNotFoundException;

    void closeDoor();
}
