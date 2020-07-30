package com.quantvalley.batch.listener;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.quantvalley.batch.model.FxMarketPricesStore;
import com.quantvalley.batch.model.StockPriceDetails;

/**
 * The Class JobCompletionNotificationListener
 *
 * @author ashraf
 */
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private static final String HEADER = "stock,open,close,low,high";

	private static final String LINE_DILM = ",";

	@Autowired
	private FxMarketPricesStore fxMarketPricesStore;

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.trace("Loading the results into file");
			Path path = Paths.get("prices.csv");
			try (BufferedWriter fileWriter = Files.newBufferedWriter(path)) {
				fileWriter.write(HEADER);
				fileWriter.newLine();
				for (StockPriceDetails pd : fxMarketPricesStore.values()) {
					fileWriter.write(new StringBuilder().append(pd.getStock())
							.append(LINE_DILM).append(pd.getOpen())
							.append(LINE_DILM).append(pd.getClose())
							.append(LINE_DILM).append(pd.getLow())
							.append(LINE_DILM).append(pd.getHigh()).toString());
					fileWriter.newLine();
				}
			} catch (Exception e) {
				log.error("Fetal error: error occurred while writing {} file", path.getFileName());
			}
		}
	}
}
