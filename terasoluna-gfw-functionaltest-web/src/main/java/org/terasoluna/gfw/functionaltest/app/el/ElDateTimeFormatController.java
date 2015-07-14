package org.terasoluna.gfw.functionaltest.app.el;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "el")
public class ElDateTimeFormatController {

    @ModelAttribute
    public DateForm5 setUpForm() {
        DateForm5 dateForm5 = new DateForm5();
        return dateForm5;
    }

    @RequestMapping(value = "6_13", method = RequestMethod.GET)
    public String init(Model model) {
        LocalDate date1 = new LocalDate(2015, 4, 1);
        LocalDate localDate1 = new LocalDate(2015, 6, 10);
        LocalDate date2 = new LocalDate(2015, 5, 1);
        LocalDate localDate2 = new LocalDate(2015, 7, 10);

        DateForm5 dateForm5 = new DateForm5(date1.toDate(), localDate1,
                new DateFormItem5(date2.toDate(), localDate2));
        model.addAttribute("dateForm5Input", dateForm5);

        return "el/dateTimeFormatQueryInput";
    }

    @RequestMapping(value = "6_13/output", method = RequestMethod.GET)
    public String listOfJavaBeanQueryString(DateForm5 dateForm5, Model model) {

        model.addAttribute("dateForm5Output", dateForm5);

        return "el/dateTimeFormatQueryOutput";
    }
}
