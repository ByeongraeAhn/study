package com.quantvalley.batch;

import com.quantvalley.batch.listener.JobCompletionNotificationListener;
import com.quantvalley.batch.model.FxMarketEvent;
import com.quantvalley.batch.model.FxMarketPricesStore;
import com.quantvalley.batch.model.Trade;
import com.quantvalley.batch.processor.FxMarketEventProcessor;
import com.quantvalley.batch.quartz.QuartzConfiguration;
import com.quantvalley.batch.reader.FxMarketEventReader;
import com.quantvalley.batch.writer.StockPriceAggregator;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 
 * @author ashraf
 */
@Configuration
@EnableBatchProcessing
@Import({QuartzConfiguration.class})
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public FxMarketPricesStore fxMarketPricesStore() {
		return new FxMarketPricesStore();
	}

	// FxMarketEventReader (Reader)
	@Bean
	public FxMarketEventReader fxMarketEventReader() {
		return new FxMarketEventReader();
	}

	// FxMarketEventProcessor (Processor)
	@Bean
	public FxMarketEventProcessor fxMarketEventProcessor() {
		return new FxMarketEventProcessor();
	}

	// StockPriceAggregator (Writer)
	@Bean
	public StockPriceAggregator stockPriceAggregator() {
		return new StockPriceAggregator();
	}

	// JobCompletionNotificationListener (File loader)
	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionNotificationListener();
	}

	// Configure job step
	@Bean
	public Job fxMarketPricesETLJob() {
		return jobBuilderFactory.get("fxmarket_prices_etl_job").incrementer(new RunIdIncrementer()).listener(listener())
				.flow(etlStep()).end().build();
	}

	@Bean
	public Step etlStep() {
		// The job is thus scheduled to run every 2 minute. In fact it should
		// be successful on the first attempt, so the second and subsequent
		// attempts should through a JobInstanceAlreadyCompleteException, so you have to set allowStartIfComplete to true
		return stepBuilderFactory.get("Extract -> Transform -> Aggregate -> Load").allowStartIfComplete(true)
				.<FxMarketEvent, Trade> chunk(10000).reader(fxMarketEventReader()).processor(fxMarketEventProcessor())
				.writer(stockPriceAggregator()).build();
	}

}
