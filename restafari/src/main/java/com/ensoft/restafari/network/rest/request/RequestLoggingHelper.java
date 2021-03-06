package com.ensoft.restafari.network.rest.request;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;

/** Helper class to log requests information */
class RequestLoggingHelper
{
	/**
	 * Gets basic request information.
	 * 
	 * @param request
	 *            Request instance to retrieve information for logging
	 * 
	 * @return Message describing request, including Method type, URL and JSON body
	 * */
	static String getRequestText(Request<?> request)
	{
		StringBuilder msg = new StringBuilder();

		msg.append("New ").append( request.getMethod() == Method.POST ? "POST" : "GET" ).append(" request").append("\n");
		msg.append("URL: ").append(request.getUrl()).append("\n");

		try
		{
			if ( null != request.getBody() )
			{
				msg.append( "BODY: " ).append( new String( request.getBody() ) ).append( "\n" );
			}
			else
			{
				msg.append( "BODY: null" );
			}
		}
		catch ( AuthFailureError authFailureError )
		{
			msg.append( "BODY: AUTHORIZATION ERROR\n" );
			msg.append( authFailureError.toString() );
		}

		return msg.toString();
	}

	/**
	 * Gets Request error information.
	 * 
	 * @param request
	 *            Request instance to retrieve information for logging
	 * 
	 * @param volleyError
	 *            Error instance to retrieve information for logging
	 * 
	 * @return Message describing error, including Method type, URL, HTTP status and JSON response
	 * */
	static String getRequestErrorText(Request<?> request, VolleyError volleyError)
	{
		StringBuilder msg = new StringBuilder();

		msg.append( request.getMethod() == Method.POST ? "POST" : "GET" ).append(" request failed ").append("\n");
		msg.append("URL: ").append(request.getUrl()).append("\n");

		String statusCode = "unknown";
		String responseData = "unknown";
		if (volleyError.networkResponse != null)
		{
			statusCode = String.valueOf(volleyError.networkResponse.statusCode);
			responseData = new String(volleyError.networkResponse.data);
		}

		msg.append("HTTP status:").append(statusCode).append("\n");
		msg.append("Response:").append(responseData).append("\n");

		return msg.toString();
	}

	/**
	 * Gets Request response information.
	 *
	 * @param request
	 *            Request instance to retrieve information for logging
	 *
	 * @param response
	 *            Response instance to retrieve information for logging
	 *
	 * @return Message describing response, including Method type, URL and JSON response
	 * */
	static String getRequestResponseText(Request<?> request, String response)
	{
		StringBuilder msg = new StringBuilder();

		msg.append(request.getMethod() == Method.POST ? "POST" : "GET").append(" request successful ").append("\n");
		msg.append("URL: ").append(request.getUrl()).append("\n");
		msg.append("Response: ").append(response).append("\n");

		return msg.toString();
	}

	/**
	 * Gets Request response information.
	 * 
	 * @param request
	 *            Request instance to retrieve information for logging
	 * 
	 * @param response
	 *            Response instance to retrieve information for logging
	 * 
	 * @return Message describing response, including Method type, URL and JSON response
	 * */
	static String getRequestResponseText(JsonRequest<?> request, JSONObject response)
	{
		StringBuilder msg = new StringBuilder();

		msg.append(request.getMethod() == Method.POST ? "POST" : "GET").append(" request successful ").append("\n");
		msg.append("URL: ").append(request.getUrl()).append("\n");
		msg.append("Response: ").append(response.toString()).append("\n");

		return msg.toString();
	}

	/**
	 * Gets Request response information.
	 *
	 * @param request
	 *            Request instance to retrieve information for logging
	 *
	 * @param response
	 *            Response instance to retrieve information for logging
	 *
	 * @return Message describing response, including Method type, URL and JSON response
	 * */
	static String getRequestResponseText(JsonRequest<?> request, JSONArray response)
	{
		StringBuilder msg = new StringBuilder();

		msg.append(request.getMethod() == Method.POST ? "POST" : "GET").append(" request successful ").append("\n");
		msg.append("URL: ").append(request.getUrl()).append("\n");
		msg.append("Response: ").append(response.toString()).append("\n");

		return msg.toString();
	}
}
