package weather.app;


import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import weather.app.web.DataExample;
import weather.app.web.TestData;


@Controller
public class MainController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }


    @RequestMapping("/test")
    public String test(Model model) {
        DataExample data = new DataExample();
        Collections.reverse(data.getData());
        model.addAttribute("provinces", data.getProvinces());
        model.addAttribute("testData", data.getData());
        return "test";
    }

    @RequestMapping(value="/test", method = RequestMethod.POST)
    public void selectedProvince(@RequestParam String provinceName, Model model) {
        DataExample data = new DataExample();
        List<TestData> testData = data.getData(provinceName);
        Collections.reverse(testData);
        model.addAttribute("provinces", data.getProvinces());
        model.addAttribute("testData", testData);
    }
    @RequestMapping(value="/newData")
    public String selectedProvince(Model model) {
        DataExample data = new DataExample();
        data.addMore();
        Collections.reverse(data.getData());
        model.addAttribute("provinces", data.getProvinces());
        model.addAttribute("testData", data.getData());
        return "test";
    }

}