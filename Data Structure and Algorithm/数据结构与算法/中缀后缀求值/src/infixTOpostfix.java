public class infixTOpostfix {
    //中缀转后缀与计算合为一趟
    public static int priority(Object operation){
        if (operation.equals('+')){
            return 1;
        }
        else if (operation.equals('*')){
            return 2;
        }
        else if (operation.equals('(')){
            return  3;
        }
        return -1;
    }

    public static void calculate(Stack number,Stack operations){
        int result=-100;
        Object firstnumber;
        Object secondnumber;
        Object operate;
        firstnumber = number.pop();
        secondnumber = number.pop();
        operate = operations.pop();
        if (operate.equals('+')) {
            result = Integer.parseInt(firstnumber+"") + Integer.parseInt(secondnumber+"");
        } else if (operate.equals('*')) {
            result = Integer.parseInt(firstnumber+"") * Integer.parseInt(secondnumber+"");
        }
        number.push(result);
    }

    public static void main(String[] args){
        char[] input="(1+2*(1+3))*2+1".toCharArray();
        Stack operations=new Stack(10);
        Stack number=new Stack(7);
        int result;
        for (int i=0;i<input.length;i++){
            if (Character.isDigit(input[i])){
                number.push(input[i]);
            }
            else if (input[i]=='+' || input[i]=='*') {
                //需要压栈的情形
                if (operations.isEmpty()) {
                    operations.push(input[i]);
                } else if (priority(operations.checktop()) < priority(input[i])) {
                    operations.push(input[i]);
                } else if (operations.checktop().equals('(')) {
                    operations.push(input[i]);
                }
                //需要计算的情形
                else if (!operations.checktop().equals('(') && priority(operations.checktop()) >= priority(input[i])) {
                    while (!operations.isEmpty() && !operations.checktop().equals('(') && priority(operations.checktop()) >= priority(input[i])) {
                        calculate(number, operations);
                    }
                    operations.push(input[i]);
                }
            }
            else if (input[i]=='('){
                operations.push(input[i]);
            }
            else if (input[i] == ')') {
                while (!operations.checktop().equals('(')){
                    calculate(number, operations);
                }
                //把左括号弹出
                operations.pop();
            }
        }
        //已经全部遍历完了
        while(!operations.isEmpty()){
            calculate(number, operations);
        }
        result=(int)number.pop();
        System.out.println(result);
    }
}
