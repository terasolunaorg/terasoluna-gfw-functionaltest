package org.terasoluna.gfw.functionaltest.app.el;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "el")
public class ElArrayController {

    @ModelAttribute
    public ArrayForm6 setUpForm() {
        ArrayForm6 arrayForm6 = new ArrayForm6(new int[] { 1, 2, 3 },
                new double[] { 1.1, 1.2 }, new byte[] { 4, 5, 6 },
                new String[] { "a", "b", "c" }, new ArrayFormItem6(new int[] {
                        11, 12, 13 }, new double[] { 11.1, 11.2 }, new byte[] {
                        14, 15, 16 }, new String[] { "d", "e", "f" }));
        return arrayForm6;
    }

    @RequestMapping(value = "6_14", method = RequestMethod.GET)
    public String init(Model model) {
        ArrayForm6 arrayForm6 = new ArrayForm6();
        model.addAttribute("arrayForm6Input", arrayForm6);

        return "el/arrayQueryInput";
    }

    @RequestMapping(value = "6_14/output", method = RequestMethod.GET)
    public String listOfJavaBeanQueryString(ArrayForm6 arrayForm6, Model model) {

        model.addAttribute("arrayForm6Output", arrayForm6);

        return "el/arrayQueryOutput";
    }
}
