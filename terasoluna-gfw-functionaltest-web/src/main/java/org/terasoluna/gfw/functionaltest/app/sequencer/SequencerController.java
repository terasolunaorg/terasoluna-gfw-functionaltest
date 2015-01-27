/*
 * Copyright (C) 2013-2015 terasoluna.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.terasoluna.gfw.functionaltest.app.sequencer;

import java.math.BigInteger;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.functionaltest.domain.service.sequencer.SequencerService;

@Controller
@RequestMapping(value = "sequencer")
public class SequencerController {
	
	@Inject
    protected SequencerService sequencerService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "sequencer/index";
    }

	@RequestMapping(value = "1_1", params = "next", method = RequestMethod.GET)
	public String fuinctionTest_1_1_get_next(Model model) {
		Integer nextval = sequencerService.getNextValueByInteger();
		model.addAttribute("nextval", nextval);
		return "sequencer/showNextval";
	}
	
	@RequestMapping(value = "1_1", params = "current", method = RequestMethod.GET)
	public String fuinctionTest_1_1_get_current(Model model) {
		Integer currval = sequencerService.getCurrentValueByInteger();
		model.addAttribute("currval", currval);
		return "sequencer/showCurrval";
	}

	@RequestMapping(value = "1_2", params = "next", method = RequestMethod.GET)
	public String fuinctionTest_1_2_get_next(Model model) {
		Long nextval = sequencerService.getNextValueByLong();
		model.addAttribute("nextval", nextval);
		return "sequencer/showNextval";
	}
	
	@RequestMapping(value = "1_2", params = "current", method = RequestMethod.GET)
	public String fuinctionTest_1_2_get_current(Model model) {
		Long currval = sequencerService.getCurrentValueByLong();
		model.addAttribute("currval", currval);
		return "sequencer/showCurrval";
	}

	@RequestMapping(value = "1_3", params = "next", method = RequestMethod.GET)
	public String fuinctionTest_1_3_get_next(Model model) {
		BigInteger nextval = sequencerService.getNextValueByBigInteger();
		model.addAttribute("nextval", nextval);
		return "sequencer/showNextval";
	}
	
	@RequestMapping(value = "1_3", params = "current", method = RequestMethod.GET)
	public String fuinctionTest_1_3_get_current(Model model) {
		BigInteger currval = sequencerService.getCurrentValueByBigIneter();
		model.addAttribute("currval", currval);
		return "sequencer/showCurrval";
	}
	
	@RequestMapping(value = "1_4", params = "next", method = RequestMethod.GET)
	public String fuinctionTest_1_4_get_next(Model model) {
		String nextval = sequencerService.getNextValueByString();
		model.addAttribute("nextval", nextval);
		return "sequencer/showNextval";
	}
	
	@RequestMapping(value = "1_4", params = "current", method = RequestMethod.GET)
	public String fuinctionTest_1_4_get_current(Model model) {
		String currval = sequencerService.getCurrentValueByString();
		model.addAttribute("currval", currval);
		return "sequencer/showCurrval";
	}

	@RequestMapping(value = "2_1", params = "next", method = RequestMethod.GET)
	public String fuinctionTest_2_1_get_next(Model model) {
		Integer nextval = sequencerService.getNotFoundSequenceNext();
		model.addAttribute("nextval", nextval);
		return "sequencer/showNextval";
	}
	
	@RequestMapping(value = "2_1", params = "current", method = RequestMethod.GET)
	public String fuinctionTest_2_1_get_current(Model model) {
		Integer currval = sequencerService.getNotFoundSequenceCurrent();
		model.addAttribute("currval", currval);
		return "sequencer/showCurrval";
	}
}
