package first_task.first_task.controller.interfaces;

import java.lang.annotation.*;

//인터페이스 마다의 뉘앙스 차이를 극복하고 재사용에 이용하기 위해 정리
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target(ElementType.TYPE)
public @interface InterfaceTransmissionDOC {
    //  Create
    //      Member -> join
    //      Order  -> order
    //      Product-> register
    //  Read
    //      Member -> check
    //      Order  -> check, checkAll, checkId
    //      Product-> check, checkAll, checkName
    //  Delete
    //      Member -> delete
    //      Order  -> delete
    //      Product-> delete -> 3개 다 통일
    //  update
    //      Member -> update
    //      Order  -> update
    //      Product-> update -> 3개 다 통일
    //                                          -> BaseController : Delete, update
    //  Create, Read -> 세부 구현
}

