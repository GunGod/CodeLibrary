## 1. 注解学习demo1
Spring自定义注解结合AOP实现以下功能：
1. 权限控制：如接口访问权限校验、角色验证
2. 日志记录：自动记录方法调用参数、返回值、执行时间
3. 参数校验：如非空检查、格式验证、范围校验
4. 事务控制：自定义事务传播行为、隔离级别
5. 缓存处理：自定义缓存策略、过期时间
6. 分布式锁：方法级的分布式锁实现
7. 异步处理：标记方法为异步执行
8. 数据脱敏：自动对敏感数据进行脱敏处理

### 1.1 核心步骤
1. 定义注解（@Interface）
首先使用Java的@interface关键字定义注解，并使用元注解（@Target、@Retention）指定注解的保留策略和作用目标。
2. 创建切面处理注解
使用Spring AOP创建切面，在切面中实现注解的业务逻辑
3. 在目标对象上使用注解
在需要实现业务逻辑的对象上使用注解
4. 启用AOP代理
确保Spring配置中启用AOP自动代理，可以通过@EnableAspectJAutoProxy注解实现。

### 1.2 ExecuteTime
记录方法执行时间注解
要点：
1. @Target 定义注解要修饰的元素，例如：方法、类、属性等
2. @Retention 定义注解的使用阶段，例如：编译时保留、类加载时保留、运行时保留

### 1.3 ExecuteTimeAspect
创建切面类，并定义切点，切点为方法执行时间注解
1. 使用@Aspect和@Component标识为切面组件
2. 使用@Around环绕通知拦截带有@ExecuteTime注解的方法
3. 记录方法执行前后的时间差，计算执行耗时
4. 从注解中获取方法描述信息
5. 使用Slf4j记录方法名、描述和执行时间到日志

### 1.4 Order
数据实体类，包含id、name和description三个字段
1. 通过@Data注解（来自Lombok库）自动生成getter、setter、toString等方法

### 1.5 OrderService
订单服务接口，定义查询所有订单的方法
1. 通过@Service注解标识为服务组件
2. 使用@ExecuteTime注解标识服务方法

### 1.6 ExecuteTimeTest
测试类，创建订单服务实例并调用查询所有订单的方法
1. 通过@Configuration注解将Test类标记为配置类
2. 使用@ComponentScan扫描指定包下的组件
3. @EnableAspectJAutoProxy启用Aspect自动代理支持

### 1.7 关键点
1. 必须使用Spring容器管理的Bean才能享受AOP功能
2. 需要启用@EnableAspectJAutoProxy来激活自动代理
3. 确保OrderService类被Spring扫描到（使用@Service或@Component注解）