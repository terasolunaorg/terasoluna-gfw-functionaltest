/*
 * Copyright (C) 2013-2016 terasoluna.org
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
package org.terasoluna.gfw.functionaltest.app.codepoints;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.common.codepoints.CodePoints;
import org.terasoluna.gfw.common.codepoints.catalog.JIS_X_0208_Katakana;

@Controller
@RequestMapping(value = "codepoints")
public class CodepointsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		
		return "codepoints/index";
	}
	
	@RequestMapping(value="01", method = RequestMethod.GET)
	public String codepoints01(Model model) {
		
		CodePoints codepoints1 = CodePoints.of(JIS_X_0208_Katakana.class);
		CodePoints codepoints2 = CodePoints.of(JIS_X_0208_Katakana.class);

		model.addAttribute("instanceCheck", codepoints1.equals(codepoints2));
		model.addAttribute("containsAll", codepoints1.containsAll("カナ"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="02", method = RequestMethod.GET)
	public String codepoints02(Model model) {
		
		CodePoints codepoints = new JIS_X_0208_Katakana();
		
		model.addAttribute("containsAll", codepoints.containsAll("カナ"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="03", method = RequestMethod.GET)
	public String codepoints03(Model model) {
		
		CodePoints codepoints = new CodePoints(0x0061, 0x0062);
		
		model.addAttribute("containsAll", codepoints.containsAll("ab"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="04", method = RequestMethod.GET)
	public String codepoints04(Model model) {
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(0x0061);
		set.add(0x0062);
		CodePoints codepoints = new CodePoints(set);
		
		model.addAttribute("containsAll", codepoints.containsAll("ab"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="05", method = RequestMethod.GET)
	public String codepoints05(Model model) {
		
		CodePoints codepoints = new CodePoints("ab");
		
		model.addAttribute("containsAll", codepoints.containsAll("ab"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="06", method = RequestMethod.GET)
	public String codepoints06(Model model) {
		
		CodePoints codepoints = new CodePoints("a", "b");
		
		model.addAttribute("containsAll", codepoints.containsAll("ab"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="07", method = RequestMethod.GET)
	public String codepoints07(Model model) {
		
		CodePoints abCp = new CodePoints(0x0061 /* a */, 0x0062 /* b */);
		CodePoints cdCp = new CodePoints(0x0063 /* c */, 0x0064 /* d */);
		CodePoints abcdCp = abCp.union(cdCp);
		
		model.addAttribute("containsAll", abcdCp.containsAll("abcd"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="08", method = RequestMethod.GET)
	public String codepoints08(Model model) {
		
		CodePoints abcdCp = new CodePoints(0x0061 /* a */, 0x0062 /* b */,
				0x0063 /* c */, 0x0064 /* d */);
		CodePoints cdCp = new CodePoints(0x0063 /* c */, 0x0064 /* d */);
		CodePoints abCp = abcdCp.subtract(cdCp);

		model.addAttribute("containsAll", abCp.containsAll("ab"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="09", method = RequestMethod.GET)
	public String codepoints09(Model model) {
		
		CodePoints abcdCp = new CodePoints(0x0061 /* a */, 0x0062 /* b */,
		        0x0063 /* c */, 0x0064 /* d */);
		CodePoints cdeCp = new CodePoints(0x0063 /* c */, 0x0064 /* d */, 0x0064 /* e */);
		CodePoints cdCp = abcdCp.intersect(cdeCp);
		
		model.addAttribute("containsAll", cdCp.containsAll("cd"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="10", method = RequestMethod.GET)
	public String codepoints10(Model model) {
		
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);
		
		model.addAttribute("containsAll", jisX208KanaCp.containsAll("カ"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="11", method = RequestMethod.GET)
	public String codepoints11(Model model) {
		
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);
		
		model.addAttribute("containsAll", jisX208KanaCp.containsAll("カナ"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="12", method = RequestMethod.GET)
	public String codepoints12(Model model) {
		
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);
		
		model.addAttribute("containsAll", jisX208KanaCp.containsAll("カナa"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="13", method = RequestMethod.GET)
	public String codepoints13(Model model) {
		
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);
		
		model.addAttribute("codepoints", jisX208KanaCp.firstExcludedCodePoint("カナ"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="14", method = RequestMethod.GET)
	public String codepoints14(Model model) {
		
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);
		
		model.addAttribute("codepoints", jisX208KanaCp.firstExcludedCodePoint("aカナ"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="15", method = RequestMethod.GET)
	public String codepoints15(Model model) {
		
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);
		
		model.addAttribute("codepoints", jisX208KanaCp.firstExcludedCodePoint("カaナ"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="16", method = RequestMethod.GET)
	public String codepoints16(Model model) {
		
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);
		
		model.addAttribute("codepoints", jisX208KanaCp.firstExcludedCodePoint("カナa"));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="17", method = RequestMethod.GET)
	public String codepoints17(Model model) {
		
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);
		Set<Integer> result = jisX208KanaCp.allExcludedCodePoints("カナ");
		
		model.addAttribute("size", result.size());
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="18", method = RequestMethod.GET)
	public String codepoints18(Model model) {
		
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);
		Set<Integer> result = jisX208KanaCp.allExcludedCodePoints("カナa");
		
		model.addAttribute("size", result.size());
		model.addAttribute("contains1", result.contains(0x0061));
		
		return "codepoints/result_containsAll";
	}
	
	@RequestMapping(value="19", method = RequestMethod.GET)
	public String codepoints19(Model model) {
		
		CodePoints jisX208KanaCp = CodePoints.of(JIS_X_0208_Katakana.class);
		Set<Integer> result = jisX208KanaCp.allExcludedCodePoints("カaナb");
		
		model.addAttribute("size", result.size());
		model.addAttribute("contains1", result.contains(0x0061));
		model.addAttribute("contains2", result.contains(0x0062));
		
		return "codepoints/result_containsAll";
	}
	
}
