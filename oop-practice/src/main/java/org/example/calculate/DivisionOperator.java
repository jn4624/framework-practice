package org.example.calculate;

public class DivisionOperator implements NewArithmeticOperator {
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        /**
         * PositiveNumber class를 통해 양수임을 보장하기 때문에 validation 체크를 하지 않아도 된다.
         * PositiveNumber class의 별도의 Test 파일을 작성하는게 올바른 것
         */
//        if (operand2.toInt() == 0) {
//            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
//        }
        return operand1.toInt() / operand2.toInt();
    }
}
