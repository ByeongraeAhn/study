package chapter01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import chapter01.http.service.HttpRequestSampleGateway;

/**
 * @author wglee21g@gmail.com
 */
public class MainApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/chapter01/http-outbound-sample-context.xml");
		HttpRequestSampleGateway sendGateway = context.getBean("messageSender", HttpRequestSampleGateway.class);

		sendGateway.sendRequest("Hello World!!!!!!");
	}
}
