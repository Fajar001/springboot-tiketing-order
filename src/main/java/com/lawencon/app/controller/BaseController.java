package com.lawencon.app.controller;

import java.util.Base64;

public abstract class BaseController {
	abstract String authUser(String user) throws Exception;
}
