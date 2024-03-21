package own.proj;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {
	public static final Properties PROPERTIES = new Properties();

	static {
		loadProperties();
	}

	private static void loadProperties() {
		try (InputStream stream = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
			PROPERTIES.load(stream);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static String get(String key) {
		return PROPERTIES.getProperty(key);
	}
}