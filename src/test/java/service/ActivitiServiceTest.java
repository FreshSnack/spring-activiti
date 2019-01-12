package service;

import net.ruixin.flow.Application;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dingmx
 * @date 2019/1/12 11:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ActivitiServiceTest {

    @Autowired
    RepositoryService repositoryService;

    @Test
    public void testGetDeployment() {
        Deployment deployment = repositoryService.createDeploymentQuery().deploymentId("2501").singleResult();
        System.out.println(deployment.getName());
        System.out.println(deployment.getKey());
        System.out.println(deployment.getDeploymentTime());
    }

    @Test
    public void testDeleteDeployment() {
        repositoryService.deleteDeployment("2501");
    }

    @Test
    public void testDeployment() {
        Deployment deployment = repositoryService.createDeployment()
                .addInputStream("leave", getClass().getResourceAsStream("/processes/leave.xml"))
                .name("leave").key("leave_key").deploy();
        System.out.println(deployment.getName());
        System.out.println(deployment.getKey());
        System.out.println(deployment.getDeploymentTime());
    }
}
