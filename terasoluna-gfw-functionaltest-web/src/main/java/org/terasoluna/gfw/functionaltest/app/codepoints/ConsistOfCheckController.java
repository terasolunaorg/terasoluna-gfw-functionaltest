package org.terasoluna.gfw.functionaltest.app.codepoints;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "codepoints")
public class ConsistOfCheckController {
	
	@ModelAttribute
	public ConsistOfCheckForm setConsistOfCheckForm() {
		return new ConsistOfCheckForm();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String consistOfCheckInput() {
		
		return "codepoints/input";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String consistOfCheck(@Validated ConsistOfCheckForm form,
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "codepoints/input";
		}

		return "codepoints/result";
	}
}
