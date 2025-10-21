package kz.shyngys.proselyte_course.module_1_4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        double[] nums = new double[100000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);

        forkJoinPool.invoke(task);

        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

class SqrtTransform extends RecursiveAction {

    final int seqThreshold = 1000;
    double[] data;
    int start;
    int end;

    public SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
        }
    }
}
