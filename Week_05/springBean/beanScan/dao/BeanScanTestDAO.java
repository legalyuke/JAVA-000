package springBean.beanScan.dao;

/**
 *
 * 当对一个类标注@Component注解时，表明该类会作为组件类，spring将为这个类创建bean。
 * 当在应用文中引用这个bean，spring会自动扫描事先指定的包查找这个 bean
 * @author liyuke
 * @date 2020-11-18 20:37
 */

@Component
public interface BeanScanTestDAO {
     void test();
}
