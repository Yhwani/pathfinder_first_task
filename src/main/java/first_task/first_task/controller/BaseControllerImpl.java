package first_task.first_task.controller;

import first_task.first_task.controller.interfaces.BaseController;
import first_task.first_task.controller.interfaces.InterfaceTransmissionDOC;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@InterfaceTransmissionDOC
public class BaseControllerImpl implements BaseController {

    @Override
    @PostMapping("/delete/{id_}")
    public String delete(@PathVariable("id_") Long id) {
        return "redirect:/";
    }

    @Override
    @PostMapping("/update/{id_}")
    public String update(@PathVariable("id_") Long id) {
        return "redirect:/";
    }
}
