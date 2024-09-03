package com.example.wmp_finalproject;
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		home_screen
	 *	@date 		Saturday 09th of December 2023 10:34:27 AM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends Activity {

	
	private View _bg__home_screen_ek2;
	private View _bg__frame_240_ek1;
	private View _bg__menu_profil_ek1;
	private ImageView ellipse_251;
	private TextView text;
	private View _bg__notification_button_ek1;
	private ImageView combo_shape;
	private View _bg__card_ek1;
	private View rectangle_8;
	private View _bg__frame_243_ek1;
	private ImageView unsplash_mbqifklvowm;
	private View _bg__frame_242_ek1;
	private TextView puma_computing_2023;
	private View _bg__avatar_ek1;
	private View _bg__avatar_ek3;
	private View ellipse_250;
	private ImageView unsplash__h6wpor9mjs;
	private TextView puma_computing_2023_ek1;
	private View rectangle_9;
	private View EventCalendarButton;
	private View unsplash_mbqifklvowm_ek2;
	private View _bg__status_bar_ek1;
	private View _bg__battery_ek1;
	private View border;
	private ImageView cap;
	private View capacity;
	private ImageView wifi;
	private ImageView cellular_connection;
	private View _bg__time_style_ek1;
	private TextView time;
	private View _bg__avatar_ek5;
	private View _bg__avatar_ek7;
	private View ellipse_250_ek1;
	private ImageView unsplash__h6wpor9mjs_ek1;
	private TextView nobody_acc;
	private View rectangle_10;
	private View rectangle_11;
	private View rectangle_12;
	private View rectangle_13;
	private TextView compsphere;
	private TextView august;
	private TextView _13;
	private TextView csgo;
	private TextView february;
	private TextView _16;
	private TextView compclub;
	private TextView april;
	private TextView _21;
	private TextView sospro;
	private TextView june;
	private TextView _22;
	private TextView hallo_kak__aku_lagi_kepikiran_banget_nih_pengen_gabung_di_organisasi__tapi_ada_satu_hal_yang_bikin_aku_agak_bingung__soalnya_aku_belum_punya_pengalaman_sama_sekali__ada_nggak_tips_dari_kakak_buat_aku_yang_mau_masuk_ke_dunia_organisasi__thanks_a_bunch_sebelumnya_ya__kak____;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		
		_bg__home_screen_ek2 = (View) findViewById(R.id._bg__home_screen_ek2);
		_bg__frame_240_ek1 = (View) findViewById(R.id._bg__frame_240_ek1);
		_bg__menu_profil_ek1 = (View) findViewById(R.id._bg__menu_profil_ek1);
		ellipse_251 = (ImageView) findViewById(R.id.ellipse_251);
		text = (TextView) findViewById(R.id.text);
		_bg__notification_button_ek1 = (View) findViewById(R.id._bg__notification_button_ek1);
		combo_shape = (ImageView) findViewById(R.id.combo_shape);

		rectangle_8 = (View) findViewById(R.id.rectangle_8);
		_bg__frame_243_ek1 = (View) findViewById(R.id._bg__frame_243_ek1);
		unsplash_mbqifklvowm = (ImageView) findViewById(R.id.unsplash_mbqifklvowm);
		_bg__frame_242_ek1 = (View) findViewById(R.id._bg__frame_242_ek1);



		ellipse_250 = (View) findViewById(R.id.ellipse_250);
		unsplash__h6wpor9mjs = (ImageView) findViewById(R.id.unsplash__h6wpor9mjs);

		rectangle_9 = (View) findViewById(R.id.rectangle_9);
		EventCalendarButton = (View) findViewById(R.id.unsplash_mbqifklvowm_ek1);
		unsplash_mbqifklvowm_ek2 = (View) findViewById(R.id.unsplash_mbqifklvowm_ek2);

		ellipse_250_ek1 = (View) findViewById(R.id.ellipse_250_ek1);
		unsplash__h6wpor9mjs_ek1 = (ImageView) findViewById(R.id.unsplash__h6wpor9mjs_ek1);

		rectangle_10 = (View) findViewById(R.id.rectangle_10);
		rectangle_11 = (View) findViewById(R.id.rectangle_11);
		rectangle_12 = (View) findViewById(R.id.rectangle_12);
		rectangle_13 = (View) findViewById(R.id.rectangle_13);


		
		//custom code goes here
	
	}

	public void CalendarEvent (View view){
		Intent intent = new Intent(Home.this, EventCalendar.class);
		startActivity(intent);
	}
}
	
	