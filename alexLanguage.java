import java.io.*;
import java.util.*;
import java.lang.Math;

public class alexLanguage extends workshop{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nalexLanguage\nHow many variables?: ");
        int enteredVar = scan.nextInt();
        System.out.print("\nVariable 1 in format (dataType.name,value)): ");
        Scanner scanVar = new Scanner(System.in);
        String varIdent=scanVar.next();
        int period = varIdent.indexOf('.');
        int comma = varIdent.indexOf(',');
        String dataType=varIdent.substring(0,period);
        String varName=varIdent.substring(period+1,comma);
        String varVal=varIdent.substring(comma+1);
        Variables lilTone = new Variables("");
        switch(dataType){
            case "int" -> {
                int iv = Integer.parseInt(varVal);
                Variables intVal = new Variables(iv);
                intVal.setName(varName);
                lilTone=intVal;
            }
            case "boolean" -> {
                boolean bv = Boolean.parseBoolean(varVal);
                Variables boolVal = new Variables(bv);
                boolVal.setName(varName);
                lilTone=boolVal;
            }
            case "char" -> {
                char chv = varVal.charAt(0);
                Variables charVal = new Variables(chv);
                charVal.setName(varName);
                lilTone=charVal;
            }
            case "byte" -> { 
                byte byv = Byte.parseByte(varVal);
                Variables byteVal = new Variables(byv);
                byteVal.setName(varName);
                lilTone=byteVal;
            }
            case "short" -> {
                short sv = Short.parseShort(varVal);
                Variables shortVal = new Variables(sv);
                shortVal.setName(varName);
                lilTone=shortVal;
            }
            case "long" -> {
                long lv = Long.parseLong(varVal);
                Variables longVal = new Variables(lv);
                longVal.setName(varName);
                lilTone=longVal;
            }
            case "float" -> {
                float flv = Float.parseFloat(varVal);
                Variables floatVal = new Variables(flv);
                floatVal.setName(varName);
                lilTone=floatVal;
            }
            case "double" -> {
                double dv = Double.parseDouble(varVal);
                Variables doubleVal = new Variables(dv);
                doubleVal.setName(varName);
                lilTone=doubleVal;
            }
            default -> {break;}
        }
        Variables lilTony = new Variables("");
        if (enteredVar == 2){
            System.out.print("\nVariable 2 in format (dataType.name,value)): ");
            String varIdent2=scanVar.next();
            int period2 = varIdent2.indexOf('.');
            int comma2 = varIdent2.indexOf(',');
            dataType = varIdent2.substring(0,period2);
            String varName2 = varIdent2.substring(period2+1,comma2);
            String varVal2 = varIdent2.substring(comma2+1);
            switch(dataType){
            case "int" -> {
                int iv = Integer.parseInt(varVal2);
                Variables intVal = new Variables(iv);
                intVal.setName(varName2);
                lilTony=intVal;
            }
            case "boolean" -> {
                boolean bv = Boolean.parseBoolean(varVal2);
                Variables boolVal = new Variables(bv);
                boolVal.setName(varName2);
                lilTony=boolVal;
            }
            case "char" -> {
                char chv = varVal2.charAt(0);
                Variables charVal = new Variables(chv);
                charVal.setName(varName2);
                lilTony=charVal;
            }
            case "byte" -> { 
                byte byv = Byte.parseByte(varVal2);
                Variables byteVal = new Variables(byv);
                byteVal.setName(varName2);
                lilTony=byteVal;
            }
            case "short" -> {
                short sv = Short.parseShort(varVal2);
                Variables shortVal = new Variables(sv);
                shortVal.setName(varName2);
                lilTony=shortVal;
            }
            case "long" -> {
                long lv = Long.parseLong(varVal2);
                Variables longVal = new Variables(lv);
                longVal.setName(varName2);
                lilTony=longVal;
            }
            case "float" -> {
                float flv = Float.parseFloat(varVal2);
                Variables floatVal = new Variables(flv);
                floatVal.setName(varName2);
                lilTony=floatVal;
            }
            case "double" -> {
                double dv = Double.parseDouble(varVal2);
                Variables doubleVal = new Variables(dv);
                doubleVal.setName(varName2);
                lilTony=doubleVal;
            }
            default -> {break;}
            }
        }
        Scanner scanChoice = new Scanner(System.in);
        System.out.println("\n1: Calculator\n2: Factorial\n3: Fibonacci\n4: Least Common Multiple\n5: Greatest Common Denominator\n6: Set to Zero");
        String choice = scanChoice.nextLine();
        switch(choice){
            case "1" -> calculator(lilTone, lilTony);
            case "2"-> factorial(lilTone);
            case "3" -> fibo(lilTone);
            case "4" -> lcm(lilTone, lilTony);
            case "5" -> gcd(lilTone, lilTony);
            case "6" -> setToZero(lilTone, lilTony);
            default -> System.out.println("Enter one of the choices");
        }
        //System.out.println(lilTone.getName() + " has a value of "+lilTone.getData());
        //System.out.println(lilTony.getName() + " has a value of "+lilTony.getData());
        scanChoice.close();
        scanVar.close();
        scan.close();
    }
    private static void calculator(Variables lilTone, Variables lilTony){
        System.out.print("\nEnter operator: ");
        Scanner scanOp = new Scanner(System.in);
        String operandString = scanOp.nextLine();
        String operand = operandString.substring(0, 1);
        String test = lilTone.getData() + operand + lilTony.getData();
        Tokenizer tokenizer = new Tokenizer(test);
        List<Token> finalTokens = tokenizer.tokenize();
        System.out.println("Tokens: " + finalTokens);
        runTest(test);
        scanOp.close();
    }
    private static void factorial(Variables n){
        if ((int) n.getData() < 0){
            System.out.println("Factorial is not defined for negative numbers.");
            return;
        }
        int result = 1;
        for (int i = 2; i <= (int) n.getData(); i++){
            result *= i;
        }
        System.out.println(n.getName() + "! = " + result);
    }
    private static int fibo(Variables n){ // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
        System.out.println("Fibonacci of " + n.getName() + ": " + fibo((int) n.getData()));
        return 1;
    }
    private static int fibo(int n){
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        return fibo(n-1) + fibo(n-2);
    }
    private static int lcm(Variables m, Variables n){
        System.out.println("Least common multiple: " + (((int) m.getData() * (int) n.getData()) / gcd(m, n)));
        return 1;
    }
    private static int gcd(Variables a, Variables b){
        if (a == b)
            return (int) a.getData();
        else if ((int) a.getData() > (int) b.getData())
            return gcd((int) a.getData() - (int) b.getData(), (int) b.getData());
        else if ((int) b.getData() > (int) a.getData())
            return gcd((int) a.getData(), (int) b.getData() - (int) a.getData());
        return 1;
    }
    private static int gcd(int a, int b){
        if (a == b)
            return a;
        else if (a > b)
            return gcd(a - b, b);
        else if (b > a)
            return gcd(a, b - a);
        return 1;
    }
    private static int setToZero(Variables a, Variables b)
    {
        int start = (int) (a.getData());
        int count = 0;
        if (start >= 0){
            while (start > 0){
                start -= (int) b.getData();
                count++;
            }
        }
        else{
            while (start < 0){
                start += (int) b.getData();
                count++;
            }
        }
        System.out.println("In/decrementations of a by b to pass 0: " + count);
        return count;
    }
}

class StackX{
    public int maxSize; 
    public char[] stackArray;
    public int top;
    public StackX(int s){
        maxSize=s;
        stackArray = new char[maxSize];
        top = -1;
    }
    public void push(char j) //push item to top bc it is a stack
    {stackArray[++top]=j;}
    
    public char pop()
    {return stackArray[top--];} // remove item from top of stack
    
    public char peek() //peek at top of stack
    {return stackArray[top];}
    
    public boolean isEmpty() //true if empty
    {return top==-1;}
    
    public boolean isFull() //true if full
    {return (top==maxSize-1);}
    
    public int size() //returns size
    {return top+1;}
    
    public char peekN(int n) //peek wherever
    {return stackArray[n];}
    
    public void displayStack(String s){ //display entire stack
        System.out.print(s);
        //System.out.print("Stack (bottom -> top): ");
        for(int j=0; j<size(); j++)
        {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println("");
    }
}

class StackXCalc
{
    private int maxSize; 
    private int[] stackArray;
    private int top;
    
    public StackXCalc(int size) //constructor for the calculation stack (Alex Maldonado)
    {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }
    
    public void push(int j) //push item to top bc it is a stack
    {stackArray[++top]=j;}
    
    public int pop(){       // remove item from top of stack
        return stackArray[top--];
    }
    
    public int peek() //peek at top of stack
    {return stackArray[top];}
    
    public boolean isEmpty() //true if empty
    {return top==-1;}
    
    public boolean isFull() //true if full
    {return (top==maxSize-1);}
    
    public int size() //returns size
    {return top+1;}
    
    public int peekN(int n) //peek wherever
    {return stackArray[n];}
    
    public void displayStack(String s) //display entire stack
    {
        System.out.print(s);
        System.out.print("Stack (bottom -> top): ");
        for(int j=0; j<size(); j++)
        {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println(" ");
    }
}

class InToPost{
    private String infixEx;
    StackX stack;
    
    public InToPost(String infix){
        infixEx = infix;
        stack = new StackX(infix.length());
    }
    
    public boolean isOperator(char c)
        {return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';}
    
    public int precedence(char c){
        int precedence = 0;
        switch(c){
            case '+' -> precedence = 1;
            case '-' -> precedence = 1;
            case '*' -> precedence = 2;
            case '/' -> precedence = 2;
            case '%' -> precedence = 2;
            case '^' -> precedence = 3;
        }
        return precedence;
    }
    
    public String postfix(){
        String output = "";
        for(int i = 0; i<infixEx.length(); i++){
            char c = infixEx.charAt(i);
            if (Character.isDigit(c) || c == '.'){
                while (i < infixEx.length() && (Character.isDigit(infixEx.charAt(i)) || infixEx.charAt(i) == '.')){
                    output += infixEx.charAt(i);
                    i++;
                }
            output += " ";
            i--;
            }
            else if (c == '(')
                stack.push(c);
            else if (c == ')'){
                while(!stack.isEmpty() && stack.peek() != '(')
                {
                    output += stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() == '(')
                {
                    stack.pop();
                }
                else
                    return "Invalid postfix expression";
            }
            else if(isOperator(c)){
                while(!stack.isEmpty() && isOperator(stack.peek()) && (precedence(stack.peek()) >= precedence(c)))
                {
                    output += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty())
        {
            char temp = stack.pop();
            if(temp =='(' || temp == ')')
                return "Invalid postfix expression";
            output += temp;
        }
        return output;
    }
}

class ParsePostfix{
    private String input;
    public ParsePostfix(String s){
        input = s;
    }
    public double doParse(){ // double return type to account for them
        double num1, num2;
        Stack<Double> stack = new Stack<>();
        String[] tokens = input.split("\s+");
        for (String token:tokens){
            if (token.matches("[0-9.]+"))
                stack.push(Double.parseDouble(token));
            else{
                num1 = stack.pop();
                num2 = stack.pop(); // In postfix, operand order is num2 <operator> num1
                switch (token){
                    case "+": stack.push(num2 + num1); break;
                    case "-": stack.push(num2 - num1); break;
                    case "*": stack.push(num2 * num1); break;
                    case "/": stack.push(num2 / num1); break;
                    case "%": stack.push(num2 % num1); break;
                    case "^": stack.push(Math.pow(num2, num1)); break;
                }
            }
        }
        return stack.pop();
    }
}

class workshop{
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static void runTest(String input){
        InToPost theTrans = new InToPost(input);
        String output = theTrans.postfix();
        System.out.println("Postfix is " + output);

        List<String> outputList = Arrays.asList(output.trim().split("\\s+"));
        Node root = Tokenizer.buildTree(outputList);
        System.out.print("Tree: ");
        Tokenizer.printTree(root);

        ParsePostfix aParser = new ParsePostfix(output);
        double outputFinal = aParser.doParse();
        System.out.println("\nEvaluates to " + outputFinal);
    }
}

class Node
{
    String value;
    Node left, right;
    public Node(String value){
        this.value = value;
    }
    public String toString(){
        return value;
    }
}

class Tokenizer{
    private static String givenText; // the full program text "9 + 10 * 21 - (2-1)"
    private static int pos = 0;              // current position
    private static char currentChar;         // the char at 'pos'

    public Tokenizer(String givenText){ //constructor
        this.givenText = givenText;
        this.currentChar = givenText.charAt(0);
    }

    public static Node buildTree(List<String> postfix){ // ["9", "+", "10", etc]
        Stack<Node> values = new Stack<>();
        for (String token:postfix){
            if(isOperator(token)){
                Node right = values.pop();
                Node left = values.pop();
                Node node = new Node(token);
                node.left = left;
                node.right = right;
                values.push(node);
            }
            else{
                values.push(new Node(token));
            }
        }
            return values.pop();
    }

    public static void printTree(Node node){
        if (node == null) return;
        boolean isOperator = isOperator(node.value);
        if (isOperator) System.out.print("(");
        if (node.left != null) printTree(node.left);
        System.out.print(node.value);
        if (node.right != null) printTree(node.right);
        if (isOperator) System.out.print(")");
    }

    private static boolean isOperator(String token){
        return "+-*/%^".contains(token);
    }

    private static void advance(){
        pos++;
        if (pos < givenText.length()){
            currentChar = givenText.charAt(pos);
        }
        else
            currentChar = '\0';
    }

    private static void skipWS(){
        while (currentChar != '\0' && Character.isWhitespace(currentChar))
            advance();
    }

    private static String number(){
        StringBuilder builder = new StringBuilder();
        while (currentChar != '\0' && (Character.isDigit(currentChar) || currentChar == '.')){
            builder.append(currentChar);
            advance();
        } 
        return builder.toString();
    }

    public static Token nextToken(){
        while (currentChar != '\0')
        {
            skipWS();
            if(Character.isDigit(currentChar) || currentChar == '.')
                return new Token(TokenType.NUMBER, number());
            switch (currentChar){
                case '+': advance(); return new Token(TokenType.PLUS, "+");
                case '-': advance(); return new Token(TokenType.MINUS, "-");
                case '*': advance(); return new Token(TokenType.MULT, "*");
                case '/': advance(); return new Token(TokenType.DIV, "/");
                case '%': advance(); return new Token(TokenType.MOD, "%");
                case '^': advance(); return new Token(TokenType.EXPO, "^");
                case '(': advance(); return new Token(TokenType.LPAREN, "(");
                case ')': advance(); return new Token(TokenType.RPAREN, ")");
                case '=': advance(); return new Token(TokenType.ASSIGN, "=");
            }
            throw new RuntimeException("Unexpected character: " + currentChar);
        }
        return new Token(TokenType.EOF, "");
    }
    public List<Token> tokenize(){
        List<Token> tokens = new ArrayList<>();
        Token token;
        while ((token = nextToken()).type != TokenType.EOF) {
            tokens.add(token);
        }
        return tokens;
    }
}

class Token{
    final TokenType type;
    final String text;     // string literal from givenText
    public Token(TokenType type, String text){
        this.type = type;
        this.text = text;
    }
    public String toString()
    {
        return text;
    }
}

enum TokenType{
    NUMBER,
    PLUS, MINUS, MULT, DIV, MOD, EXPO,
    LPAREN, RPAREN, ASSIGN, EOF
}

class Variables{
    private Object data;
    private String name;
    public Variables(Object data)
        {this.data = data;}
    public Object getData()
        {return this.data;}
    public Variables setName(String name){
        this.name = name.trim();
        return this;
    }
    public String getName()
        {return name;}
}