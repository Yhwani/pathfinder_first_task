package first_task.first_task.dto;

import lombok.Getter;
import static org.springframework.data.domain.Sort.*;

@Getter
public class PageRequest {

    private int page = 1;
    private int size = 20;
    private Direction direction = Direction.DESC;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public org.springframework.data.domain.PageRequest of() {
        return org.springframework.data.domain.PageRequest.of(page-1,size,direction,"순서대로");
    }

}