package com.krystal.ai.testService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CumlationService {
	
	@Value("${number.limit}")
	private Integer limit;
	
	@Value("${duration.limit}")
	private Integer maxDurationLimit;
	
    private CopyOnWriteArrayList<Integer> nList = new CopyOnWriteArrayList<Integer>();

	public List<Integer> getNumbers(Integer lastMinute) {
		int size = nList.size();
		int maxNos = lastMinute * 60 * limit;
		
		if(size > maxNos) {
			int start = size - maxNos;
			List<Integer> sublist = nList.subList(start, size);
			return sublist;
		}else {
			return new ArrayList<>(nList);
		}
	}
	
	@Scheduled(initialDelay = 0L, fixedDelay = 1000L)
	public void generatedNumbers() {
		int count = 0;
		Random random = new Random();
		while (count < limit) {
			nList.add(random.nextInt());
			count++;
		}

		int size = nList.size();
		int maxNos = limit * maxDurationLimit * 60;
		if (size > maxNos) {
			int diff = size - maxNos;
			List<Integer> sublist = nList.subList(0, diff);
			nList.removeAll(sublist);
		}

	}

}
