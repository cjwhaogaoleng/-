package exam_xier.e02;

public class arr3  {
    public static void main(String[] args) {
         Thread t1=new Thread(()->{
             int[] arr1 = {1, 3, 5, 7, 9};
             for (int j : arr1) {
                 System.out.println(j);
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         });
         t1.setPriority(10);
         Thread t2=new Thread(()->{
                 int[] arr1 = {2, 4, 6, 8, 10};
                 for (int j : arr1) {
                     System.out.println(j);
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
         });
         t1.start();
         t2.start();

        System.out.println(isLegal("317a39A_579@qq.com"));
        System.out.println(isLegal("317a39A_57911111111@qq.com"));
        //长度为19
        }


        //邮箱
    //只列举了一些常见的后缀格式
    public static boolean isLegal(String email){
        return email.matches("[a-z|A-Z|_|0-9|]{6,18}(@)(qq.com|163、com|126、com|139、com|sohu.com|aliyun.com|189、cn)");
    }
}

