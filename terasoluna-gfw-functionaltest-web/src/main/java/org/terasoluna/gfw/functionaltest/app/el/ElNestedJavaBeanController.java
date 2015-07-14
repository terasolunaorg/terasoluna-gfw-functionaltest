package org.terasoluna.gfw.functionaltest.app.el;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "el")
public class ElNestedJavaBeanController {

    @ModelAttribute
    public SearchUserForm1 setUpForm() {
        SearchUserForm1 searchUserForm1 = new SearchUserForm1();
        return searchUserForm1;
    }

    @RequestMapping(value = "6_9", method = RequestMethod.GET)
    public String init(Model model) {

        SearchUserForm1 searchUserForm1 = new SearchUserForm1(
                new SearchUserCriteriaForm1("yamada", 20), true);
        model.addAttribute("searchUserForm1Input", searchUserForm1);

        return "el/nestedJavaBeanQueryInput";
    }

    @RequestMapping(value = "6_9/output", method = RequestMethod.GET)
    public String nestedJavaBeanQueryString(SearchUserForm1 searchUserForm1,
            Model model) {

        System.out.println(searchUserForm1.getCriteria().getName());
        model.addAttribute("searchUserForm1Output", searchUserForm1);

        return "el/nestedJavaBeanQueryOutput";
    }
}
