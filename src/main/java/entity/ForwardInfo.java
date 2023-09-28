package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author YZX
 * @Create 2023-09-27 11:38
 * @Java-version jdk1.8
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
//转发节点信息
public class ForwardInfo {
    //转发目的节点IP
    String destination;
    //转发网关
    String gateway;
}
