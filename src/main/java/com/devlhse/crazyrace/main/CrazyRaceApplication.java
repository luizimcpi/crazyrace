package com.devlhse.crazyrace.main;

import com.devlhse.crazyrace.service.ResultService;
import com.devlhse.crazyrace.view.impl.*;

public class CrazyRaceApplication {
	
	public static void main(String[] args) {
		ResultService resultService = new ResultService();
		FileView fileView = new FileView(resultService);
		fileView.init();
	}
	
}
