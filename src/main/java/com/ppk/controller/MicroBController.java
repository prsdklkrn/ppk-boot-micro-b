package com.ppk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.ppk.service.MicroBService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "mscontent", description = "Exposes endpoints to read content required for edge", position = 0)
@RestController
@RequestMapping
public class MicroBController {

	private static final String	MS_BASE_METRIC_URL	= "/ms/v2/content";

	private final MicroBService	microAService;

	@Autowired
	public MicroBController(MicroBService microAService) {
		this.microAService = microAService;
	}

	@Timed(name = MS_BASE_METRIC_URL + " == [GET]", absolute = true)
	@ExceptionMetered(name = MS_BASE_METRIC_URL + " == [GET " + ExceptionMetered.DEFAULT_NAME_SUFFIX
			+ "]", absolute = true)
	@ApiOperation(value = "Get content  ", notes = "Get content ")
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> welcomeMessage() {
		return microAService.getContent();
	}

}
