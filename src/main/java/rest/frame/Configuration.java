package rest.frame;

import java.util.Properties;

import org.restexpress.Format;
import org.restexpress.RestExpress;
import org.restexpress.common.exception.ConfigurationException;
import org.restexpress.util.Environment;

import rest.frame.controller.DemoController;

/**
 * 
 * @author Dhanushanth
 *@version 1.0
 */
public class Configuration extends Environment{
	private static final String NAME_PROPERTY = "name";
	private static final String PORT_PROPERTY = "port";
	private static final String DEFAULT_FORMAT_PROPERTY = "default.Format";
	private static final String BASE_URL_PROPERTY = "base.url";
	
	private int port;
	private String name;
	private String defaultFormat;
	private String baseUrl;
	
	private DemoController democontroller;
	
	@Override
	protected void fillValues(Properties p) throws ConfigurationException {
		//First it will check the Environment property if not It will get from the rest express Default values
		this.name = p.getProperty(NAME_PROPERTY, RestExpress.DEFAULT_NAME);
		this.port = Integer.parseInt(p.getProperty(PORT_PROPERTY, String.valueOf(RestExpress.DEFAULT_PORT)));
		this.defaultFormat = p.getProperty(DEFAULT_FORMAT_PROPERTY, Format.JSON);
		this.baseUrl = p.getProperty(BASE_URL_PROPERTY, "http://localhost:" + String.valueOf(port));
		this.democontroller = new DemoController();
	}

	public String getBaseUrl()
	{
		return baseUrl;
	}

	public String getDefaultFormat()
	{
		return defaultFormat;
	}

	public int getPort()
	{
		return port;
	}

	public String getName()
	{
		return name;
	}

	public DemoController getDemoController() {
		return democontroller;
	}

}
