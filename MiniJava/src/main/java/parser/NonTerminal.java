package parser;


public enum NonTerminal {
    Goal("$"),
    save("$|public|class|{|if|while|System.out.println|}|return|ID|=|else"),
    Source("$"),
    MainClass("$"),
    defClass("{|extends|public|class"),
    defMethod("("),
    defMain("("),
    ClassDeclarations("public"),
    ClassDeclaration("public|class"),
    Extension("{"),
    FieldDeclarations("public|class|}"),
    FieldDeclaration("public|class|}|static"),
    VarDeclarations("$|{|if|while|System.out.println|ID|=|}|public|return"),
    VarDeclaration("$|{|if|while|System.out.println|ID|=|}|boolean|int|public|return"),
    MethodDeclarations("}"),
    MethodDeclaration("}|public"),
    Parameters(")"),
    defParam(",|)"),
    Parameter(")"),
    Type("public|class|}|static|ID|;|$|{|if|while|System.out.println|=|boolean|int|(|)|,|return"),
    Statements("}|return|{|if|while|System.out.println|ID|="),
    Statement("}|return|{|if|while|System.out.println|ID|=|else"),
    JPF_save("{|if|while|System.out.println|}|return|ID|=|else"),
    lbl("("),
    checkid("="),
    pid("ID"),
    GenExpression(";|)|,"),
    Expression(";|)|+|-|==|&&|<|,"),
    Term(";|)|+|-|*|==|&&|<|,"),
    Factor(";|)|+|-|*|==|&&|<|,"),
    startCall("("),
    Kpid("true|false"),
    intPid("NUM"),
    RelExpression(";|)|&&|,"),
    RelTerm(";|)|&&|,"),
    Arguments(")"),
    arg(",|)"),
    Argument(")"),
    Identifier("$|{|public|class|extends|;|}|(|)|,|return|if|while|System.out.println|ID|=|else|+|-|*|.|==|&&|<"),
    Integer(";|)|+|-|*|==|&&|<|,");

    public final String pattern;

    NonTerminal(String pattern) {
        this.pattern = pattern;
    }
}
