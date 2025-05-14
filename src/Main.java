interface MyInterface {
    default void doSomething(){
        System.out.println("Default doing something");
    }
}

class ClassA implements MyInterface {
    @Override
    public void doSomething() {
        System.out.println("Class A doing something");
    }
}

class ClassB implements MyInterface{
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
            } else {
                System.out.println("Object does not implement MyInterface");
            }
        }
    }
}