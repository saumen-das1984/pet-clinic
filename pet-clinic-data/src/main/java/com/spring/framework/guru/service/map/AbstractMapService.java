package com.spring.framework.guru.service.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.spring.framework.guru.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
	
	protected Map<Long, T> map = new HashMap<>();
	
	Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save (T object) {
		
		if(null!=object) {
			if(null==object.getId()) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		} else {
			throw new RuntimeException("Object can't be null");
		}
		return object;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete (T object ) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	private Long getNextId() {
		Long nextId = null;
		try {
			nextId = Collections.max(map.keySet())+1;
		} catch (Exception e) {
			nextId = 1L;
		}
		return nextId;
	}

}
