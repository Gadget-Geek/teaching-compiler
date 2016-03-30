.class public Print1
.super java/lang/Object

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 10
    .limit locals 10

    ; X is variable 0
    ; I is variable 1

    ; X = 0
    ldc 0
    istore 0

    ; I = ...
    ldc 5
    istore 1

    loop_123:

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Hello world"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    ; X = X + 1
    iinc 0 1
    
    ; if X < I GOTO loop_123
    iload 0
    iload 1
    if_icmplt loop_123

    return
.end method
