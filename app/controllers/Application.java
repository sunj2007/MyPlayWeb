package controllers;

import play.*;
import play.data.validation.Valid;
import play.mvc.*;
import sun.management.HotspotThreadMBean;

import java.util.*;

import models.*;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void register() {
		render();
	}

	public static void saveUser(@Valid User user, String verifyPassword) {
		validation.required(verifyPassword);
		validation.equals(verifyPassword, user.password).message("Your password doesn't match");
		if (validation.hasErrors()) {
			render("@register", user, verifyPassword);
		}
		
		user.create(); // create db
		session.put("user", user.username);
		flash.success("Welcome,", user.realname);
		
		
		
		//render();
	}

}