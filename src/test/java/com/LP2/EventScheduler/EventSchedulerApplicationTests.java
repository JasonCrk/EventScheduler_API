package com.LP2.EventScheduler;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
class EventSchedulerApplicationTests {

	@Test
	void contextLoads() {
	}

}
