package org.example.gradeCalulate;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;
//    private final List<Course> courses;

    public GradeCalculator(Courses courses) {
        this.courses = courses;
    }
//    public GradeCalculator(List<Course> courses) {
////        this.courses = courses;
//        this.courses = new Courses(courses);
//    }

    /**
     * 요구사항
     * 1. 평균학점 계산 방법 = (학점수 * 교과목 평점)의 합계 / 수강신청 총 학점 수
     * 2. 일급 컬렉션 사용 -> 클래스 객체 -> Courses
     */
    public double calculateGrade() {
        // (학점수 * 교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();
//        double multipliedCreditAndCourseGrade = 0;
//        for (Course course : courses) {
////            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
//            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
//        }

        // 수강신청 총 학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();
//        int totalCompletedCredit = courses.stream()
//                .mapToInt(Course::getCredit)
//                .sum();

        return totalMultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
