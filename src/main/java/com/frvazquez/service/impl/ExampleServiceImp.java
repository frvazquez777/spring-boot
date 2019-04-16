package com.frvazquez.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.stereotype.Service;

import com.frvazquez.model.Person;
import com.frvazquez.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImp implements ExampleService {

	private static final Log LOG = LogFactory.getLog(ExampleServiceImp.class);
	
	@Override
	public List<Person> getListPeople() {
		List<Person> list = new ArrayList<Person>();
		DataFactory df = new DataFactory();
		for (int i = 0; i < 100; i++) {
			list.add(new Person(df.getName(), df.getNumberBetween(17, 70)));
		}
		LOG.info("Services People");
		return list;
	}

}
