package org.terasoluna.gfw.functionaltest.app.el;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "el")
public class ElSimpleJavaBeanAndListOfJavaBeanController {

    @ModelAttribute
    public SearchAndBatchUpdateUserForm3 setUpForm() {
        SearchAndBatchUpdateUserForm3 searchAndBatchUpdateUserForm3 = new SearchAndBatchUpdateUserForm3();
        return searchAndBatchUpdateUserForm3;
    }

    @RequestMapping(value = "6_11", method = RequestMethod.GET)
    public String init(Model model) {

        SearchAndBatchUpdateUserForm3 searchAndBatchUpdateUserForm3 = new SearchAndBatchUpdateUserForm3(
                new SearchUserCriteriaForm3("suzuki", 30), Arrays.asList(
                        new User3("yamada", 20), new User3("tanaka", 50)));
        model.addAttribute("searchAndBatchUpdateUserForm3Input",
                searchAndBatchUpdateUserForm3);

        return "el/simpleJavaBeanAndListOfJavaBeanQueryInput";
    }

    @RequestMapping(value = "6_11/output", method = RequestMethod.GET)
    public String listOfJavaBeanQueryString(
            SearchAndBatchUpdateUserForm3 searchAndBatchUpdateUserForm3,
            Model model) {

        model.addAttribute("searchAndBatchUpdateUserForm3Output",
                searchAndBatchUpdateUserForm3);

        return "el/simpleJavaBeanAndListOfJavaBeanQueryOutput";
    }
}
