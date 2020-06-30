package cn.marring.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static final int TIMEOUT = 60000;
    private HttpUtil() {

    }

    public static String post(String url, Map<String, String> headers, String body) throws IOException, HttpException {
        // 添加参数
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(body));
        return dealHttpPost(httpPost, headers);
    }

    public static CloseableHttpClient createSSLClientDefault(){
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy(){
                //信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return HttpClients.createDefault();
    }

    private static String dealHttpPost(HttpPost request, Map<String, String> headers) throws IOException, HttpException {
        CloseableHttpResponse response = null;
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(TIMEOUT).setConnectionRequestTimeout(TIMEOUT)
                .setSocketTimeout(TIMEOUT).build();
        request.setConfig(requestConfig);
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }
            response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if (code != HttpStatus.SC_OK && code != HttpStatus.SC_CREATED) {
                throw new HttpException(request.getURI().getPath() + response.getStatusLine().toString());
            }
            HttpEntity responseEntity = response.getEntity();
            return EntityUtils.toString(responseEntity, "utf-8");
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    public static Map<String, String> getHeader() {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");
        return headers;
    }
}
