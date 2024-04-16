package com.koreait.exam.batch_ex_24_04.job.HelloWorld;


import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HelloWorldConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job helloWorldJob(Step helloWorldStep1) {
        return jobBuilderFactory.get("helloWorldJob").start(helloWorldStep1).build();  //jobbuilder를 가져오는것
        
    }
    @Bean
    public Step helloWorldStep1(Tasklet helloWorldTasklet) {
        return stepBuilderFactory.get("helloWorldStep1").tasklet(helloWorldTasklet).build();
    }

    @Bean
    public Tasklet helloWorldTasklet() {
        return (stepContribution, chunkContext) -> {
            System.out.println("헬로월드!!!");
            return RepeatStatus.FINISHED;
        };
    }
    // Job : 여러가지의 Step들로 구성
}
