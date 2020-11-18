package springBean.beanScan.service.Impl;

import springBean.beanScan.dao.BeanScanTestDAO;
import springBean.beanScan.service.BeanScanTestService;

/**
 * @author liyuke
 * @date 2020-11-18 20:55
 */
@Component
public class BeanScanTestServiceImpl implements BeanScanTestService {
    @Autowired
    private BeanScanTestDAO beanScanTestDAO;

    @Override
    public void testService() {
        beanScanTestDAO.test();
    }
}
