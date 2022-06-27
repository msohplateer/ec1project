package com.plateer.ec1.claim.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.plateer.ec1.claim.enums.ClaimType;
import com.plateer.ec1.claim.worker.creator.ClaimCreator;

@Component
public class CreatorFactory {
	
	Map<ClaimType, ClaimCreator> factoryMap = new HashMap<>();
	List<ClaimCreator> creatorList;
	
	
	public CreatorFactory(List<ClaimCreator> creatorList) {
		this.creatorList = creatorList;
		creatorList.forEach(c -> factoryMap.put(c.getType(), c));
	}
	
	public ClaimCreator getCreator(ClaimType type) {
		return factoryMap.get(type);
	}
}
