package com.ppk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MicroBServiceImpl implements MicroBService {

	@Override
	public Map<String, String> getContent() {
		Map<String, String> content = new HashMap<>();
		content.put("copy", "Content served from Micro ---> B");
		return content;
	}

}
