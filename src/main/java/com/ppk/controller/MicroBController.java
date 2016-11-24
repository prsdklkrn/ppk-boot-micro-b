package com.ppk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ppk.service.MicroBServiceImpl;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "mscontent", description = "Exposes endpoints to read content required for edge", position = 0)
@RestController
@RequestMapping
public class MicroBController {

	private final MicroBServiceImpl microAService;

	@Autowired
	public MicroBController(MicroBServiceImpl microAService) {
		this.microAService = microAService;
	}

	@ApiOperation(value = "Get content  ", notes = "Get content ")
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> welcomeMessage() {
		return microAService.getContent();
	}

}
