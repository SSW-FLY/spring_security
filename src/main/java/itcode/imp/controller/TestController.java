package itcode.imp.controller;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import itcode.imp.util.ScrewUtil;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imp
 * @date 2020/12/9
 */
@RestController
public class TestController {


    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("/api/projects/hma")
    public String test() {
        return "hma";
    }

    @GetMapping("/api/projects/hma1")
    public void test1() {
        DataSource bean = applicationContext.getBean(DataSource.class);
        EngineConfig config = EngineConfig.builder()
            .fileOutputDir("J:\\test")
            .openOutputDir(false)
            .fileType(EngineFileType.HTML)
            .produceType(EngineTemplateType.freemarker).build();

        Configuration test = Configuration.builder().version("1.0.3").description("生成文档test")
            .dataSource(bean)
            .engineConfig(config).produceConfig(ScrewUtil.getProcessConfig()).build();

        new DocumentationExecute(test).execute();

    }

}
