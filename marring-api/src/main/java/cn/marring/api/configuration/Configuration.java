package cn.marring.api.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Configuration
 *
 * @author Wn 2020-05-19 18:37
 */
public class Configuration {
    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);

    private static final Map<String, Configuration> INSTANCES = new HashMap();
    private static final Object LOCK = new Object();
    private Properties properties = new Properties();

    private Configuration(String fileName) {
        try {
            String jarPath = URLDecoder.decode(Configuration.class.getProtectionDomain().getCodeSource().getLocation().getFile(), "UTF-8");
            String cwd = jarPath.substring(0, jarPath.lastIndexOf("/") + 1);
            File localConfigFile = new File(cwd + "config" + "/" + fileName);
            if (localConfigFile.exists()) {
                this.properties.load(new InputStreamReader(new FileInputStream(localConfigFile)));
            } else {
                this.properties.load(new InputStreamReader(this.getClass().getResourceAsStream("/" + fileName), StandardCharsets.UTF_8));
            }
        } catch (IOException var5) {
            logger.error(var5.getMessage());
        }

    }

    public static Configuration getConfig(String fileName) {
        if (!INSTANCES.containsKey(fileName)) {
            synchronized (LOCK) {
                if (!INSTANCES.containsKey(fileName)) {
                    Configuration configuration = new Configuration(fileName);
                    INSTANCES.put(fileName, configuration);
                }
            }
        }

        return (Configuration) INSTANCES.get(fileName);
    }

    public int getInt(String str) {
        return Integer.parseInt(this.properties.getProperty(str));
    }

    public long getLong(String str) {
        return Long.parseLong(this.properties.getProperty(str));
    }

    public double getDouble(String str) {
        return Double.parseDouble(this.properties.getProperty(str));
    }

    public String getString(String str) {
        return this.properties.getProperty(str);
    }

    public boolean getBoolean(String str) {
        return Boolean.parseBoolean(this.properties.getProperty(str));
    }

    public Map<String, String> config2Map() {
        Map<String, String> configMap = new HashMap();
        Iterator var2 = this.properties.keySet().iterator();

        while (var2.hasNext()) {
            Object key = var2.next();
            configMap.put(key.toString(), this.properties.getProperty(key.toString()));
        }

        return configMap;
    }
}
