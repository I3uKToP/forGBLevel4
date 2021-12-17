package v.kiselev.composite;

public class Main {
    public static void main(String[] args) {
        FilePackage filePackage = new FilePackage("/home/viktor");
        System.out.println(filePackage.averageSize());
    }
}
