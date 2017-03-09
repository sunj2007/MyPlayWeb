package controllers;

import java.util.List;

import models.Hotel;
import play.mvc.Controller;

public class Hotels extends Controller {
	public static void index() {
		render();
	}
	
	
    public static void list(String search, Integer size, Integer page) {
        List<Hotel> hotels = null;
        page = page != null ? page : 1;
        if(search.trim().length() == 0) {
            hotels = Hotel.all().fetch(page, size);
        } else {
            search = search.toLowerCase();
            hotels = Hotel.find("lower(name) like ? OR lower(city) like ?", "%"+search+"%", "%"+search+"%").fetch(page, size);
        }
        render(hotels, search, size, page);
    }
	
}
