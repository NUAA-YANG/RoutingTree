package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author YZX
 * @Create 2023-09-27 11:36
 * @Java-version jdk1.8
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
//路由节点
public class Node {
    //节点名称
    String name;
    //节点拥有的网卡IP地址集合
    List<String> interfaceList;
}
