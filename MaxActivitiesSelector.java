package HW2208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Activity {
    int start;
    int end;
    int index;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class MaxActivitiesSelector {
    public static List<Integer> maxActivities(List<Activity> activities) {
        List<Integer> selectedIndexes = new ArrayList<>();

        // Сортируем активности по конечному времени
        activities.sort(Comparator.comparingInt(a -> a.end));

        Activity prevActivity = null;
        for (Activity activity : activities) {
            if (prevActivity == null || activity.start >= prevActivity.end) {
                selectedIndexes.add(activity.index);
                prevActivity = activity;
            }
        }

        return selectedIndexes;
    }

    public static void main(String[] args) {
        List<Activity> activities = Arrays.asList(
                new Activity(1, 4, 0),
                new Activity(3, 5, 1),
                new Activity(0, 6, 2),
                new Activity(5, 7, 3),
                new Activity(3, 8, 4),
                new Activity(5, 9, 5),
                new Activity(6, 10, 6),
                new Activity(8, 11, 7)
        );

        List<Integer> result = maxActivities(activities);
        System.out.println("Результат: " + result);
    }
}
