package org.example.gradeCalculate;

import org.example.gradeCalulate.Course;
import org.example.gradeCalulate.Courses;
import org.example.gradeCalulate.GradeCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 요구사항
 * 1. 평균학점 계산 방법 = (학점수 * 교과목 평점)의 합계 / 수강신청 총 학점 수
 * 2. 일급 컬렉션 사용
 */
public class gradeCalculatorTest {
    /**
     * 1. 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
     * - 이수한 과목(객체지향프로그래밍, 자료구조, 중국어회화), 학점 계산기
     * 2. 객체들 간의 관계를 고민
     * - 학점 계산기가 이수한 과목을 인스턴스 변수로 가지면서 평균 학점을 계산할 수 있을 것 같다
     * 3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
     * - 객체지향프로그래밍, 자료구조, 중국어회화 --> 과목(코스) 클래스로 표현한다는 의미
     * 4. 객체들을 포괄하는 타입에 적절한 책임을 할당하며 협력을 설계 ( **** 핵심 포인트 **** )
     * - 이수한 과목을 인자로 전달하여 평균 학점 계산을 요청 --> 학점 계산기 --> (학점수 * 교과목 평점)의 합계 --> 과목(코스) -> 학점 수와 교과목 평점을 알고 있는 객체(일급 컬렉션)
     *                                                        --> 수강신청 총 학점 수         --> 과목(코스) -> 학점 수와 교과목 평점을 알고 있는 객체(일급 컬렉션)
     */

    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+"));

//        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        GradeCalculator gradeCalculator = new GradeCalculator(new Courses(courses));
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);
    }
}
