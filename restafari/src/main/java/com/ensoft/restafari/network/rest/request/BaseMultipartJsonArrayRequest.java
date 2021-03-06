package com.ensoft.restafari.network.rest.request;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class BaseMultipartJsonArrayRequest extends MultipartRequest<JSONArray>
{
	public BaseMultipartJsonArrayRequest( int method, String url, JSONObject parameters, Map<String, String> headers, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener )
	{
		super( method, url, parameters, headers, listener, errorListener );
	}

	@Override
	protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
		try {
			String jsonString = new String(response.data,
				HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
			return Response.success(new JSONArray(jsonString),
				HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JSONException je) {
			return Response.error(new ParseError(je));
		}
	}
}
