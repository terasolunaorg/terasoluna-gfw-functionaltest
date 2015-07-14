package org.terasoluna.gfw.functionaltest.app.el;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "el")
public class ElListOfJavaBeanController {

    @ModelAttribute
    public BatchUpdateUserForm2 setUpForm() {
        BatchUpdateUserForm2 batchUpdateUserForm2 = new BatchUpdateUserForm2();
        return batchUpdateUserForm2;
    }

    @RequestMapping(value = "6_10", method = RequestMethod.GET)
    public String init(Model model) {

        BatchUpdateUserForm2 batchUpdateUserForm2 = new BatchUpdateUserForm2(
                Arrays.asList(new UpdateUserCriteriaForm2("yamada", 20),
                        new UpdateUserCriteriaForm2("tanaka", 50)),
                LogicalOperator2.AND);
        model.addAttribute("batchUpdateUserForm2Input", batchUpdateUserForm2);

        return "el/listOfJavaBeanQueryInput";
    }

    @RequestMapping(value = "6_10/output", method = RequestMethod.GET)
    public String listOfJavaBeanQueryString(
            BatchUpdateUserForm2 batchUpdateUserForm2, Model model) {

        model.addAttribute("batchUpdateUserForm2Output", batchUpdateUserForm2);

        return "el/listOfJavaBeanQueryOutput";
    }
}
