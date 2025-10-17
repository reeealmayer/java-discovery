package kz.shyngys.proselyte_course.module_1_3.lambdas_interfaces;

public class EmptyArrayException extends Exception {
    EmptyArrayException() {
        super("Массив пуст");
    }
}
