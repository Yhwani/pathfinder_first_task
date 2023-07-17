package first_task.first_task.controller.Interfaces;

import first_task.first_task.controller.InterfaceTransmissionDOC;

@InterfaceTransmissionDOC
public interface BaseController {
    String delete(Long id);
    String update(Long id);
}
