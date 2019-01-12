package service;

import net.ruixin.flow.Application;
import net.ruixin.flow.service.FlowService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dingmx
 * @date 2019/1/12 11:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FlowServiceTest {

    @Autowired
    FlowService flowService;

    @Test
    public void test() {
        Assert.assertNotNull(flowService);
        System.out.println(flowService);
    }

    @Test
    public void testDeploy() {
        flowService.deploy("leave");
    }
}
