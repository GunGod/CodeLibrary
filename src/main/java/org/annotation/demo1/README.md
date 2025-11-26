## 注解学习demo1

### ExecuteTime
记录方法执行时间注解
要点：
1. @Target 定义注解要修饰的元素，例如：方法、类、属性等
2. @Retention 定义注解的使用阶段，例如：编译时保留、类加载时保留、运行时保留

### ExecuteTimeAspect
创建切面类，并定义切点，切点为方法执行时间注解
1. 使用@Aspect和@Component标识为切面组件
2. 使用@Around环绕通知拦截带有@ExecuteTime注解的方法
3. 记录方法执行前后的时间差，计算执行耗时
4. 从注解中获取方法描述信息
5. 使用Slf4j记录方法名、描述和执行时间到日志

### Order
数据实体类，包含id、name和description三个字段
1. 通过@Data注解（来自Lombok库）自动生成getter、setter、toString等方法

### OrderService
订单服务接口，定义查询所有订单的方法
1. 通过@Service注解标识为服务组件
2. 使用@ExecuteTime注解标识服务方法

### Test
测试类，创建订单服务实例并调用查询所有订单的方法
1. 通过@Configuration注解将Test类标记为配置类
2. 使用@ComponentScan扫描指定包下的组件
3. @EnableAspectJAutoProxy启用Aspect自动代理支持

### 关键点
1. 必须使用Spring容器管理的Bean才能享受AOP功能
2. 需要启用@EnableAspectJAutoProxy来激活自动代理
3. 确保OrderService类被Spring扫描到（使用@Service或@Component注解）