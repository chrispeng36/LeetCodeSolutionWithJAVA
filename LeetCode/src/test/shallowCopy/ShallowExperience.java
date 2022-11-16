package test.shallowCopy;

/**
 * @author ChrisPeng
 * @date 2022/10/13 11:27
 */
public class ShallowExperience {
    private String skill;

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setShallowExperience(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return skill;
    }
}
