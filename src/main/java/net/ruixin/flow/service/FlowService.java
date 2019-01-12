package net.ruixin.flow.service;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author dingmx
 * @date 2019/1/12 10:34
 */
@Service
/*@Slf4j*/
public class FlowService {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    RepositoryService repositoryService;

    /**
     * 发布规则文件
     * @param bpmnName
     */
    public void deploy(String bpmnName) {
        String bpmn = "processes/" + bpmnName + ".xml";
        //String png = "processes/" + bpmnName + ".png";
        repositoryService.createDeployment()//创建一个部署对象
                .name(bpmnName)//添加部署的名称
                .addInputStream(bpmn, this.getClass().getClassLoader().getResourceAsStream(bpmn))
                //.addInputStream(png, this.getClass().getClassLoader().getResourceAsStream(png))
                .deploy();//完成部署
    }

    /**
     * 启动流程
     * @param defKey 流程定义key
     * @param variables 流程变量
     */
    public ProcessInstance startFlow(String defKey, Map variables) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(defKey, variables);
        return processInstance;
    }
}
