package app.bean.session.goaltick;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 */
public class GoalTick {

    /**
     * Created with IntelliJ IDEA.
     * User: Maksymilian
     * Date: 22.07.12
     * Time: 18:33
     * To change this template use File | Settings | File Templates.
     */
    private class GoalDoesNotExistException extends Exception {
        public GoalDoesNotExistException() {
            super("Nie ma takiego zadanie na liście zadań! ");
        }
    }
    private Map<String, Boolean> taskList;

    private boolean completed;

    public GoalTick() {
        completed = false;
    }

    public GoalTick(String... goalsToAchieve) {
        this();
        taskList = new LinkedHashMap<String, Boolean>();
        for (String goal : goalsToAchieve) {
            taskList.put(goal, false);
        }
    }

    public void tickGoal(String goal) throws GoalDoesNotExistException {
        if (!taskList.containsKey(goal)) {
            throw new GoalDoesNotExistException();
        }
        taskList.put(goal, true);
        checkCompleted();
    }

    public void checkCompleted() {
        if (!taskList.values().contains(false)) {
            completed = true;
        }
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
