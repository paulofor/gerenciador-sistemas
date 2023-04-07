package br.com.digicom.coletorjson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;



public class ParserJson2 extends Thread {

	private  ICallbackJSON callback;

	private List<Header> listaHeader = new ArrayList<Header>();
	
	public ParserJson2(ICallbackJSON callback) {
		this.callback = callback;
	}

	public void addHeader(Header header) {
		this.listaHeader.add(header);
	}
	
	public void run() {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

		
		try {
			certificado(httpClientBuilder);
			CloseableHttpClient httpclient = httpClientBuilder.build();
			HttpPost httppost = new HttpPost(this.callback.getUrl().toURI());
			for (Header h : listaHeader) {
				httppost.addHeader(h);
			}
			StringEntity entity = new StringEntity(this.callback.getBody());
			httppost.setEntity(entity);

			
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					System.out.println(callback.getUrl());
					System.out.println("Resposta: " + status);
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}

			};
			String responseBody = httpclient.execute(httppost, responseHandler);
			this.callback.setString(responseBody);

			this.callback.inicializacao();
			if (this.callback instanceof ICallbackJSON) {
				responseBody = responseBody.trim();
				if ('[' == (responseBody.charAt(0))) {
					JSONArray result = new JSONArray(responseBody);
					((ICallbackJSON) callback).setJsonList(result);
				} else {
					JSONObject result = new JSONObject(responseBody);
					((ICallbackJSON) callback).setJson(result);
				}

			}
			this.callback.finalizacaoOk();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}

	
	
	private void certificado(HttpClientBuilder client) throws GeneralSecurityException {
		SSLContext ctx = SSLContext.getInstance("TLS");
		ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
		SSLContext.setDefault(ctx);
		client.setSSLContext(ctx);
	}
	
	 private void setSSL(HttpClientBuilder client) 
	            throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

	        // use the TrustSelfSignedStrategy to allow Self Signed Certificates
	        SSLContext sslContext = SSLContextBuilder
	                .create()
	                .loadTrustMaterial(new TrustSelfSignedStrategy())
	                .build();

	        // we can optionally disable hostname verification. 
	        // if you don't want to further weaken the security, you don't have to include this.
	        HostnameVerifier allowAllHosts = new NoopHostnameVerifier();
	        
	        // create an SSL Socket Factory to use the SSLContext with the trust self signed certificate strategy
	        // and allow all hosts verifier.
	        SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, allowAllHosts);
	        
	        // finally create the HttpClient using HttpClient factory methods and assign the ssl socket factory
	        //client.setSslcontext(sslcontext)  .custom()
	        //        .setSSLSocketFactory(connectionFactory)
	 }
	
	 private static class DefaultTrustManager implements X509TrustManager {

	        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

	        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

	        public X509Certificate[] getAcceptedIssuers() {
	            return null;
	        }
	    }
}
