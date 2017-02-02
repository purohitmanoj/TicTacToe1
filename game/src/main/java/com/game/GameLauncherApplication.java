/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.game;

import com.game.entity.TicTacToeGame;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class GameLauncherApplication {

//	@Autowired
	public  static  TicTacToeGame ticTacToeGame = new TicTacToeGame();


	public static void main(String[] args) throws Exception {
		// System.exit is common for Batch applications since the exit code can be used to
		// drive a workflow
//		System.exit(SpringApplication.exit(SpringApplication.run(
//				SampleBatchApplication.class, args)));


		String s = "Y";
		while("Y".equalsIgnoreCase(s.trim())) {
			ticTacToeGame.startGame();
			System.out.println(" Do you want to play more to Play more enter Y ");
			BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
			s = BR.readLine();
			if(s!=null && !s.isEmpty()){
				s = s.trim();
			}

		}


	}
}