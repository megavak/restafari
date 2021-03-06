package com.ensoft.restafari_app.example;

import android.app.Application;
import android.content.Context;

import com.ensoft.restafari.database.DatabaseService;
import com.ensoft.restafari.database.TableCollection;
import com.ensoft.restafari.network.service.RequestService;

public class App extends Application
{
	@Override
	public void onCreate()
	{
		super.onCreate();

		RequestService.init( this );
	}

	@Override
	protected void attachBaseContext(Context base)
	{
		super.attachBaseContext( base );

		TableCollection tableCollection = new TableCollection( "ipdb", 1 );
		tableCollection.add( new IpTable() );

		DatabaseService.init( this, tableCollection );
	}
}
