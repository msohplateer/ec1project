package com.plateer.ec1.claim.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateer.ec1.claim.service.ClaimService;
import com.plateer.ec1.claim.vo.ClaimVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/claim")
@RequiredArgsConstructor
public class ClaimController {
	
	private final ClaimService service;
	
	public void claim(ClaimVo vo) {
		
	}
}
