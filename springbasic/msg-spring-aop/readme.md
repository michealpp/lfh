## AOP

#### 基本概念
* concern关注点，比如安全检查
* aspect @Aspect切片，模块化的concern，即把concern放入aspect
* jonit point 执行切片的地方
* advice切片中处理关注点的方法
before advice
after returning advice
after throwing advice
after advice
around advice
* pointcut切入点
* advised object
* weave
In AOP, weaving is the process of creating advised objects by linking aspects with other
required objects. In Spring AOP, weaving happens at runtime, while AspectJ performs
weaving at compile time or load time.
