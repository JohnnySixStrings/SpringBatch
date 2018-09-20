package financebatch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;

public class FileMoveTasklet implements Tasklet,InitializingBean {



    private String sourceDir;
    private String targetDir;

    public FileMoveTasklet(String sourceDir, String targetDir) {
        this.sourceDir = sourceDir;
        this.targetDir = targetDir;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext){
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources;
        try {
            resources = patternResolver.getResources(sourceDir);

            for (Resource resource:resources) {

              Files.move(Paths.get(resource.getURI()),Paths.get(targetDir),ATOMIC_MOVE);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return  null;

    }

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(sourceDir,"source directory needs to be set");
        Assert.notNull(targetDir,"target directory needs to be set");
    }
}


