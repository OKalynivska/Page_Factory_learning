package own.proj;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {
	private static PropertiesUtil instance;
	private final Properties properties = new Properties();

	public static synchronized PropertiesUtil getPropertiesInstance() {
		if (instance == null) {
			instance = new PropertiesUtil();
		}
		return instance;
	}

	private PropertiesUtil() {
		try (InputStream stream = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
			properties.load(stream);
		} catch (IOException e) {
			throw new IllegalStateException("Failed to load properties", e);
		}
	}

	public String get(String key) {
		return properties.getProperty(key);
	}
}