package test.shallowCopy;


public class TestMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("======浅拷贝======");
        shallowCloneTest();
    }

    /**
     * 浅拷贝测试用例
     *
     * @throws CloneNotSupportedException
     */
    private static void shallowCloneTest() throws CloneNotSupportedException {
        ShallowCloneTest test = new ShallowCloneTest();
        test.setShallowExperience("我是小明，我精通Java，C++的复制粘贴");
        test.show();
        ShallowCloneTest cloneTest = (ShallowCloneTest) test.clone();
        cloneTest.show();
        cloneTest.setShallowExperience("我是小明的副本，我精通Java,C++");
        cloneTest.show();
        test.show();
        System.out.println(cloneTest.getAge());
    }
}
