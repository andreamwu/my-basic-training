## Lambda表达式
**可以传递匿名函数的一种方式：有参数列表、函数主体、返回类型、可能还会有一个可以抛出的异常列表**

- 匿名
- 函数
- 传递
    > Lambda表达式可以作为参数传递给方法或存储在变量中
- 简洁

### 组成
  Lambda表达式由 参数 箭头 主体 组成
` (parameters) -> expression ` 或 ` (parameters) -> { statements; } `
  
### 使用
- 函数式接口
  * 在函数式接口中使用
  * 函数式接口：函数式接口就是只定义一个抽象方法的接口，是一个具体实现的实例
  * 函数式接口都带有`@FunctionalInterface`注解
  
- 练习
  > LambdaSample.java

  > 资源处理时，常见的模式就是打开一个资源，做一些处理，然后关闭资源。
   环绕执行（execute around）模式:设置和清理阶段总是很类似，并且会围绕着执行处理的那些重要代码

  * 步骤
  1. 行为参数化
  2. 使用函数式接口传递行为
  3. 执行一个行为
  4. 传递Lambda
  
  * 使用函数式接口。
   ` java.util.function `
     > Predicate 
     >> T-> boolean
                                     
     > Consumer
     >> T-> void
                                     
     > Function
     >> T-> R   
                                                                                                                                                                                                               
  * 函数式接口带来了一个专门的版本，以便在输入和输出都是原始类型时避免自动装箱的操作
     > 一般来说，针对专门的输入参数类型的函数式接口的名称都要加上对应的原始类型前缀，比
    如 DoublePredicate 、 IntConsumer 、 LongBinaryOperator 、 IntFunction 等。 Function
    接口还有针对输出参数类型的变种： ToIntFunction<T> 、 IntToDoubleFunction 等。
                                               
  * 类型检查、类型推断已经限制
  * 方法引用
  
  