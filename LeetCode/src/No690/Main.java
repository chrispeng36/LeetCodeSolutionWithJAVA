package No690;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChrisPeng
 * @date 2022/12/15 16:02
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

class Solution {
    Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (Integer subordinate : subordinates) {
            total += dfs(subordinate);
        }
        return total;
    }
}
