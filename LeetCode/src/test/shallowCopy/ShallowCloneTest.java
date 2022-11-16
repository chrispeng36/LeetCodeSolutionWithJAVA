package test.shallowCopy;

/**
 * @author ChrisPeng
 * @date 2022/10/13 11:27
 */
public class ShallowCloneTest implements Cloneable {

    private int age;
    private ShallowExperience shallowExperience;

    public ShallowCloneTest() {
        this.age = 10;
        this.shallowExperience = new ShallowExperience();
    }

    public ShallowExperience getExperience() {
        return shallowExperience;
    }

    public void setShallowExperience(String skill) {
        shallowExperience.setShallowExperience(skill);
    }

    public void show() {
        System.out.println(shallowExperience.toString());
    }

    public int getAge() {
        return age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (ShallowCloneTest) super.clone();
    }
}
