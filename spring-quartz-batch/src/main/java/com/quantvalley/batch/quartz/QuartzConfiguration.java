package com.quantvalley.batch.quartz;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * The Class QuartzConfiguration.
 *
 * @author ashraf
 */
@Configuration
public class QuartzConfiguration {
	
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private JobLocator jobLocator;

	@Bean
	public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
		JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
		jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
		return jobRegistryBeanPostProcessor;
	}
	
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean jobfactory = new JobDetailFactoryBean();
		jobfactory.setJobClass(QuartzJobLauncher.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobName", "fxmarket_prices_etl_job");
		map.put("jobLauncher", jobLauncher);
		map.put("jobLocator", jobLocator);
		jobfactory.setJobDataAsMap(map);
		jobfactory.setGroup("etl_group");
		jobfactory.setName("etl_job");
		return jobfactory;
	}

	// Job is scheduled after every 2 minute
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean() {
		CronTriggerFactoryBean ctFactory = new CronTriggerFactoryBean();
		ctFactory.setJobDetail(jobDetailFactoryBean().getObject());
		ctFactory.setStartDelay(3000);
		ctFactory.setName("cron_trigger");
		ctFactory.setGroup("cron_group");
		ctFactory.setCronExpression("5 * * * * ? *");
		return ctFactory;
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		scheduler.setTriggers(cronTriggerFactoryBean().getObject());
		return scheduler;
	}

}
