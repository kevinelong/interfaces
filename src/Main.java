interface MyInterface {
    default void doSomething(){
        System.out.println("Default doing something");
    }
}
interface AnotherInterface {
    default void doSomethingElse(){
        System.out.println("Default doing something else");
    }
}

class ClassA implements MyInterface {
    @Override
    public void doSomething() {
        System.out.println("Class A doing something");
    }
}

class ClassB implements MyInterface, AnotherInterface{
    public void doSomethingElse() {
        System.out.println("Class B doing something else");
    }
}
class ClassC {
    public void doSomethingElse() {
        System.out.println("Class B doing something else");
    }
}

public class Main {
    public static void main(String[] args) {
        Object[] objects = {new ClassA(), new ClassB(), new ClassC()};

        for (Object obj : objects) {
            if (obj instanceof MyInterface) {
                ((MyInterface) obj).doSomething();
//                MyInterface myInterface = (MyInterface) obj;
//                myInterface.doSomething();
            }

            if (obj instanceof AnotherInterface) {
                ((AnotherInterface) obj).doSomethingElse();
            }
            if(!(obj instanceof MyInterface && !(obj instanceof AnotherInterface))){
                System.out.println("Object does not implement either Interface");
            }
        }
    }
}