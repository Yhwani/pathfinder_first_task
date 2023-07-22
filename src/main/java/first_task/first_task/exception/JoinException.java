package first_task.first_task.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JoinException extends RuntimeException{
    private ErrorCode errorCode;
    private String message;

    @Override
    public String toString() {
        if (message == null) {
            errorCode.getMessage();
        }
        return String.format("%s %s", errorCode.getMessage(), message);

    }
}
