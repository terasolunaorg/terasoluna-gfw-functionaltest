package org.terasoluna.gfw.functionaltest.app.el;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "el")
public class ElMapOfJavaBeanController {

    @ModelAttribute
    public SearchForm4 setUpForm() {
        SearchForm4 searchForm4 = new SearchForm4();
        return searchForm4;
    }

    @RequestMapping(value = "6_12", method = RequestMethod.GET)
    public String init(Model model) {

        SearchForm4 searchForm4 = new SearchForm4(
                new LinkedHashMap<String, String>() {
                    {
                        put("aaa", "111");
                        put("bbb", "222");
                        put("ccc", "333");
                    }
                });
        model.addAttribute("searchForm4Input", searchForm4);

        return "el/mapOfJavaBeanQueryInput";
    }

    @RequestMapping(value = "6_12/output", method = RequestMethod.GET)
    public String listOfJavaBeanQueryString(SearchForm4 searchForm4, Model model) {

        model.addAttribute("searchForm4Output", searchForm4);

        return "el/mapOfJavaBeanQueryOutput";
    }
}
