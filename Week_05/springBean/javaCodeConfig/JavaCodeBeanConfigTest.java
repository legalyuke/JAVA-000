package springBean.javaCodeConfig;

/**
 * @author liyuke
 * @date 2020-11-18 20:59
 */
@Configuration
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:scan.xml"}）
public class JavaCodeBeanConfigTest {
    @Bean(name = "javaCodeBeanTest")
        public javaCodeBeanTest getBean(){
        return new ****();
        }
}
