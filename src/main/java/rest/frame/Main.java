package rest.frame;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.jboss.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;
import org.restexpress.util.Environment;


/**
 * 
 * @author Dhanushanth
 *
 */
public class Main {

	public static void main(String[] args) throws Exception{
		//args is the property file
		Configuration conf = loadEnvironment(args);
		RestExpress server = new RestExpress()
		.setBaseUrl(conf.getBaseUrl())
		.setPort(conf.getPort());
		
		callServices(conf,server);
		server.bind(conf.getPort());
		server.awaitShutdown();

	}

	private static void callServices(Configuration conf, RestExpress server) {
		server.uri("/demo", conf.getDemoController())
		.method(HttpMethod.GET).method(HttpMethod.POST);
		
	}

	private static Configuration loadEnvironment(String[] args) throws FileNotFoundException, IOException {
		if (args.length > 0) {
			return Environment.from(args[0], Configuration.class);
		}
		return Environment.fromDefault(Configuration.class);
	}

}
