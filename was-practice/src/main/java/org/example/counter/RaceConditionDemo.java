package org.example.counter;

public class RaceConditionDemo {
    /**
     * 상태를 유지(stateful)하게 설계하면 안됨
     * Thread safety 하지 않음(스레드가 안전하지 않다로 표현) 의 예시
     *
     * 멀티스레드 환경에서 하나의 객체를 공유하게 되면(싱글톤)
     * 뜻하지 않은 레이스 컨디션 즉, 원치 않는 결과가 나올 수 있는 것을 볼 수 있다.
     *
     * 레이스 컨디션이란?
     * 여러 프로세스 혹은 스레드가 동시에 하나의 자원에 접근하기 위해 경쟁하는 상태
     *
     * 이 예시는 동기화 처리로 쉽게 해결 가능
     */
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
