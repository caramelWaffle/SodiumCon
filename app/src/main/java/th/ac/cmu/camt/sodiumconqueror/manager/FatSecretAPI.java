package th.ac.cmu.camt.sodiumconqueror.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import android.util.Base64;


import org.json.JSONException;
import org.json.JSONObject;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Bitwarp on 7/5/2016.
 */

public class FatSecretAPI {

    final private String APP_KEY;

    final private String APP_SECRET;


    final private String APP_URL = "http://platform.fatsecret.com/rest/server.api";


    final private String APP_SIGNATURE_METHOD = "HmacSHA1";


    final private String HTTP_METHOD = "GET";


    public FatSecretAPI(String APP_KEY, String APP_SECRET) {
        this.APP_KEY = APP_KEY;
        this.APP_SECRET = APP_SECRET;
    }


    public String nonce() {
        Random r = new Random();
        StringBuffer n = new StringBuffer();
        for (int i = 0; i < r.nextInt(8) + 2; i++) {
            n.append(r.nextInt(26) + 'a');
        }
        return n.toString();
    }


    public String[] generateOauthParams() {
        String[] a = {
                "oauth_consumer_key=" + APP_KEY,
                "oauth_signature_method=HMAC-SHA1",
                "oauth_timestamp=" + new Long(System.currentTimeMillis() / 1000).toString(),
                "oauth_nonce=" + nonce(),
                "oauth_version=1.0",
                "format=json"
        };
        return a;
    }


    public String join(String[] params, String separator) {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < params.length; i++) {
            if (i > 0) {
                b.append(separator);
            }
            b.append(params[i]);
        }
        return b.toString();
    }


    public String paramify(String[] params) {
        String[] p = Arrays.copyOf(params, params.length);
        Arrays.sort(p);
        return join(p, "&");
    }


    public String encode(String url) {
        if (url == null)
            return "";

        try {
            return URLEncoder.encode(url, "utf-8")
                    .replace("+", "%20")
                    .replace("!", "%21")
                    .replace("*", "%2A")
                    .replace("\\", "%27")
                    .replace("(", "%28")
                    .replace(")", "%29");
        } catch (UnsupportedEncodingException wow) {
            throw new RuntimeException(wow.getMessage(), wow);
        }
    }


    public String sign(String method, String uri, String[] params) throws UnsupportedEncodingException {

        String encodedURI = encode(uri);
        String encodedParams = encode(paramify(params));

        String[] p = {method, encodedURI, encodedParams};

        String text = join(p, "&");
        String key = APP_SECRET + "&";
        SecretKey sk = new SecretKeySpec(key.getBytes(), APP_SIGNATURE_METHOD);
        String sign = "";
        try {
            Mac m = Mac.getInstance(APP_SIGNATURE_METHOD);
            m.init(sk);
            sign = encode(new String(Base64.encode(m.doFinal(text.getBytes()), Base64.DEFAULT)).trim());
        } catch (java.security.NoSuchAlgorithmException e) {

        } catch (java.security.InvalidKeyException e) {

        }
        return sign;
    }


    public JSONObject getFoodItems(String query) throws UnsupportedEncodingException, JSONException {
        JSONObject result = new JSONObject();

        List<String> params = new ArrayList<String>(Arrays.asList(generateOauthParams()));
        String[] template = new String[1];
        params.add("method=foods.search");
        params.add("max_results=20");
        params.add("search_expression=" + encode(query));
        params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

        try {
            URL url = new URL(APP_URL + "?" + paramify(params.toArray(template)));
            URLConnection api = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(api.getInputStream()));

            while ((line = reader.readLine()) != null) builder.append(line);

            JSONObject json = new JSONObject(builder.toString());

            result.put("result", json);

        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("message", "There was an error in processing your request. Please try again later.");
            result.put("error", error);
        }

        return result;
    }


    public JSONObject getFoodItemsAtPageNumber(String query, int pageNumber) throws UnsupportedEncodingException, JSONException {
        JSONObject result = new JSONObject();

        List<String> params = new ArrayList<String>(Arrays.asList(generateOauthParams()));
        String[] template = new String[1];
        params.add("method=foods.search");
        params.add("max_results=50");
        params.add("page_number=" + pageNumber);
        params.add("search_expression=" + encode(query));
        params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

        try {
            URL url = new URL(APP_URL + "?" + paramify(params.toArray(template)));
            URLConnection api = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(api.getInputStream()));

            while ((line = reader.readLine()) != null) builder.append(line);

            JSONObject json = new JSONObject(builder.toString());

            result.put("result", json);

        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("message", "There was an error in processing your request. Please try again later.");
            result.put("error", error);
        }

        return result;
    }

    public JSONObject getFoodItem(long id) throws UnsupportedEncodingException, JSONException {
        JSONObject result = new JSONObject();

        List<String> params = new ArrayList<String>(Arrays.asList(generateOauthParams()));
        String[] template = new String[1];
        params.add("method=food.get");
        params.add("food_id=" + encode("" + id));
        params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

        try {
            URL url = new URL(APP_URL + "?" + paramify(params.toArray(template)));
            URLConnection api = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(api.getInputStream()));

            while ((line = reader.readLine()) != null) builder.append(line);

            JSONObject json = new JSONObject(builder.toString());

            result.put("result", json);

        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("message", "There was an error in processing your request. Please try again later.");
            result.put("error", error);
        }

        return result;
    }


    public JSONObject getRecipes(String query) throws UnsupportedEncodingException, JSONException {
        JSONObject result = new JSONObject();
        List<String> params = new ArrayList<String>(Arrays.asList(generateOauthParams()));
        String[] template = new String[1];
        params.add("method=recipes.search");
        params.add("max_results=50");
        params.add("search_expression=" + encode(query));
        params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

        try {
            URL url = new URL(APP_URL + "?" + paramify(params.toArray(template)));
            URLConnection api = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(api.getInputStream()));

            while ((line = reader.readLine()) != null) builder.append(line);

            JSONObject json = new JSONObject(builder.toString());
            result.put("result", json);

        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("message", "There was an error in processing your request. Please try again later.");
            result.put("error", error);
        }
        return result;
    }


    public JSONObject getRecipesAtPageNumber(String query, int pageNumber) throws UnsupportedEncodingException, JSONException {
        JSONObject result = new JSONObject();
        List<String> params = new ArrayList<String>(Arrays.asList(generateOauthParams()));
        String[] template = new String[1];
        params.add("method=recipes.search");
        params.add("max_results=50");
        params.add("page_number=" + pageNumber);
        params.add("search_expression=" + encode(query));
        params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

        try {
            URL url = new URL(APP_URL + "?" + paramify(params.toArray(template)));
            URLConnection api = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(api.getInputStream()));

            while ((line = reader.readLine()) != null) builder.append(line);

            JSONObject json = new JSONObject(builder.toString());
            result.put("result", json);

        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("message", "There was an error in processing your request. Please try again later.");
            result.put("error", error);
        }
        return result;
    }


    public JSONObject getRecipe(long id) throws UnsupportedEncodingException, JSONException {
        JSONObject result = new JSONObject();

        List<String> params = new ArrayList<String>(Arrays.asList(generateOauthParams()));
        String[] template = new String[1];
        params.add("method=recipe.get");
        params.add("recipe_id=" + encode("" + id));
        params.add("oauth_signature=" + sign(HTTP_METHOD, APP_URL, params.toArray(template)));

        try {
            URL url = new URL(APP_URL + "?" + paramify(params.toArray(template)));
            URLConnection api = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(api.getInputStream()));

            while ((line = reader.readLine()) != null) builder.append(line);

            JSONObject json = new JSONObject(builder.toString());

            result.put("result", json);

        } catch (Exception e) {
            JSONObject error = new JSONObject();
            error.put("message", "There was an error in processing your request. Please try again later.");
            result.put("error", error);
        }
        return result;
    }

}
