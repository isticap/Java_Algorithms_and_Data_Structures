/**
 * This stores and interprets a postfix expression. A postfix expression 
 * is an expression where the operands appear before their operators (ex. 4 5 + )
 * 
 * You will need to implement validExpression() which determines if the expression is 
 * a valid postfix expression
 * @author YOUR NAME HERE
 */
public class PostfixEvaluator {

    private String expr;
    
    public PostfixEvaluator(String expr) {
        this.expr = expr;
    }
    
    /**
     * This method will determine if the expression stored in expr is a valid postfix
     * expression. A postfix expression has one of the following formats:
     *  => value (ex. 42)
     *  => value value operator (ex. 2 3 +)
     *  => expression value operator (ex. 2 3 + 4 *)
     *  => value expression operator (ex. 2 3 4 + *)
     *  => expression expression operator (ex. 2 3 + 4 5 * +)
     * @return true if the expression is valid, false if it is not.
     */
    public boolean validExpression() {
        int valCounter = 0;
        String [] tokens = expr.trim().split("\\s++");
        for (String t : tokens) {
            if (isOperator(t))
                valCounter--;
            else {
                try {
                    double d = Double.parseDouble(t);
                    valCounter++;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            if (valCounter < 0)
                return false;
        }
        return valCounter == 1;
    }
    
    /**
     * Using a Stack, evaluate the postfix expression in expr.
     * This is done as follows:
     *  Read the expression left to right.
     *  If the current token is a numeric, push the value on the stack.
     *  If the current token is an operator, pop the top two values from the stack,
     *   apply the operation to those values, and push the result onto the stack.
     *  Repeat with all tokens.
     *  When you reach the end of the expression, there should be exactly
     *  one value on the stack. That is the result of the expression. Return
     *  that value.
     * @return the value of the expression
     */
    public double evaluate() {
        if (!validExpression())
            throw new IllegalStateException("Invalid expression");
        Stack<Double> values = new LinkedStack<>();
        String[] tokens = expr.trim().split("\\s++");
        for(int i=0; i<tokens.length; i++){
            if (isOperator(tokens[i])){
                switch(tokens[i]){
                    case ("+"):
                        Double temp1 = values.pop() + values.pop();
                        values.push(temp1);
                        break;
                    case ("-"):
                        Double temp2 = -(values.pop()) + values.pop();
                        values.push(temp2);
                        break;
                    case ("*"):
                        Double temp3 = values.pop() * values.pop();
                        values.push(temp3);
                        break;
                    case ("/"):
                        Double temp4 = Math.pow((values.pop() / values.pop()),-1);
                        values.push(temp4);
                        break;
                    case ("^"):
                        Double v1 = values.pop();
                        Double v2 = values.pop();
                        Double temp5 = Math.pow(v2, v1);
                        values.push(temp5);
                        break;
                }
            } else {
                values.push(Double.parseDouble(tokens[i]));
            }
                
                
        }
        
        return values.pop();
    }
    
    /**
     * Return true if the token is an operator ( + - * / ^ )
     * Return false otherwise.
     * @param token
     * @return 
     */
    public boolean isOperator(String token) {
        String s = token.trim();
        if (s.length() != 1)
            return false;
        return "+-*/^".contains(s);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String [] exprs = {"42", "2 3 +", "12.5 2 *", "1 2 + 3 *", "2.5 15 + 2 3 * /", "2 3", "12 +"};
        for (String e : exprs) {
            PostfixEvaluator p = new PostfixEvaluator(e);
            System.out.println("Expression: " + e);
            System.out.println("Valid: " + p.validExpression());
            if (p.validExpression())
                System.out.println("Value: " + p.evaluate());
        }
    }
    
}
