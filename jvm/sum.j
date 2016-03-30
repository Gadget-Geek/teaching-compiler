.class public Sum1
.super java/lang/Object

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 10
    .limit locals 10

    ; compute the sum from 0 to N
    ; i is register 0
    ; N is register 1
    ; result is register 2

    ; N = 1000
    ldc 1000
    istore 1

    ; i = 0
    ldc 0
    istore 0

    ; result = 0
    ldc 0
    istore 2

    ; loop
    loop:

    ; result = result + i
    iload 2
    iload 0
    iadd
    istore 2

    ; i = i + 1
    iinc 0 1

    ; if i <= N GOTO loop
    iload 0
    iload 1
    if_icmple loop

    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "SUM = "
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 2
    invokevirtual java/io/PrintStream/println(I)V

    return
.end method
