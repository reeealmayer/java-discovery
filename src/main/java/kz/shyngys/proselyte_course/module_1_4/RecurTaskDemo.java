package kz.shyngys.proselyte_course.module_1_4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecurTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        double[] nums = new double[500];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        Sum task = new Sum(nums, 0, nums.length);
        Double invoke = forkJoinPool.invoke(task);

        System.out.println("результат: " + invoke);
    }
}

class Sum extends RecursiveTask<Double> {
    final int seqThreshold = 500;
    double[] data;
    int start;
    int end;

    public Sum(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        double sum = 0;

        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            int middle = (start + end) / 2;

            Sum subTaskA = new Sum(data, middle, end);
            Sum subTaskB = new Sum(data, start, middle);

            subTaskA.fork();
            subTaskB.fork();

            sum = subTaskA.join() + subTaskB.join();
        }

        return sum;
    }
}
