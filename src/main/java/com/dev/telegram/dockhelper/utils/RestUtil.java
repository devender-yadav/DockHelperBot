package com.dev.telegram.dockhelper.utils;

import static com.dev.telegram.dockhelper.utils.Constants.MAX_RETRY;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class RestUtil to fetch data via GET request
 * 
 * @author devender
 */
public class RestUtil {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(RestUtil.class);


	private RestUtil() {
	}

	/**
	 * Fetch data.
	 *
	 * @param url the url
	 * @return the string
	 */
	public static String fetchData(String url) {
		int retry = 0;
		String data = null;
		while (retry <= MAX_RETRY) {
			try {
				data = getReq(url);
				break;
			} catch (Exception ex) {
				retry++;
			}
			CommonUtil.sleep();
		}
		return data;
	}

	/**
	 * Gets the req.
	 *
	 * @param url the url
	 * @return the req
	 */
	public static String getReq(String url) {

		Client client = ClientBuilder.newClient();
		try {
			WebTarget target = client.target(url);
			Builder builder = target.request();

			Response response = builder.get();
			return response.readEntity(String.class);

		} catch (Exception ex) {
			LOGGER.error("Error in getting response", ex);
			return null;
		} finally {
			client.close();
		}
	}

}
