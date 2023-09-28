package vnp;

import entity.ForwardInfo;
import entity.Node;

import java.util.*;

/**
 * @Author YZX
 * @Create 2023-09-27 15:28
 * @Java-version jdk1.8
 */
//构建节点和路由表
public class CreateEnv {

    //获得主机节点
    public HashMap<String,Node>  getHostMap(){
        //添加节点
        Node H411 = new Node("H411",new ArrayList<>(Arrays.asList("10.0.1.1")));
        Node H421 = new Node("H421",new ArrayList<>(Arrays.asList("10.0.3.1")));
        Node H211 = new Node("H211",new ArrayList<>(Arrays.asList("10.0.11.1")));
        Node H221 = new Node("H221",new ArrayList<>(Arrays.asList("10.0.10.1")));
        HashMap<String,Node> hostMap = new HashMap<>();
        hostMap.put("H411",H411);
        hostMap.put("H421",H421);
        hostMap.put("H211",H211);
        hostMap.put("H221",H221);
        return hostMap;
    }

    //获得路由节点
    public HashMap<String,Node> getRouterMap(){
        //添加节点
        Node R41 = new Node("R41",new ArrayList<>(Arrays.asList("10.0.1.2","10.0.2.1","10.0.5.1")));
        Node R42 = new Node("R42",new ArrayList<>(Arrays.asList("10.0.2.2","10.0.3.2","10.0.4.1")));
        Node R4 = new Node("R4",new ArrayList<>(Arrays.asList("10.0.4.2","10.0.5.2","10.0.6.1")));
        Node R2 = new Node("R2",new ArrayList<>(Arrays.asList("10.0.6.2","10.0.7.1","10.0.8.1")));
        Node R21 = new Node("R21",new ArrayList<>(Arrays.asList("10.0.7.2","10.0.9.2","10.0.11.2")));
        Node R22 = new Node("R22",new ArrayList<>(Arrays.asList("10.0.8.2","10.0.9.1","10.0.10.2")));

        HashMap<String,Node> routerMap = new HashMap<>();
        routerMap.put("R41",R41);
        routerMap.put("R42",R42);
        routerMap.put("R4",R4);
        routerMap.put("R2",R2);
        routerMap.put("R21",R21);
        routerMap.put("R22",R22);
        return routerMap;
    }

    //获得全部节点
//    public List<Node> getAllNodeList(){
//        //添加节点
//        Node H411 = new Node("H411",new ArrayList<>(Arrays.asList("10.0.1.1")));
//        Node H421 = new Node("H421",new ArrayList<>(Arrays.asList("10.0.3.1")));
//        Node H211 = new Node("H211",new ArrayList<>(Arrays.asList("10.0.11.1")));
//        Node H221 = new Node("H221",new ArrayList<>(Arrays.asList("10.0.10.1")));
//
//        Node R41 = new Node("R41",new ArrayList<>(Arrays.asList("10.0.1.2","10.0.2.1","10.0.5.1")));
//        Node R42 = new Node("R42",new ArrayList<>(Arrays.asList("10.0.2.2","10.0.3.2","10.0.4.1")));
//        Node R4 = new Node("R4",new ArrayList<>(Arrays.asList("10.0.4.2","10.0.5.2","10.0.6.1")));
//        Node R2 = new Node("R2",new ArrayList<>(Arrays.asList("10.0.6.2","10.0.7.1","10.0.8.1")));
//        Node R21 = new Node("R21",new ArrayList<>(Arrays.asList("10.0.7.2","10.0.9.2","10.0.11.2")));
//        Node R22 = new Node("R22",new ArrayList<>(Arrays.asList("10.0.8.2","10.0.9.1","10.0.10.2")));
//
//        List<Node> nodeList = new ArrayList<>(Arrays.asList(H411,H421,H211,H221,R41,R42,R4,R2,R21,R22));
//        return nodeList;
//    }

    //获取H411节点的路由表
    public List<ForwardInfo> getH411RoutingTable(){
        ForwardInfo forwardInfo1 = new ForwardInfo("0.0.0.0", "10.0.1.2");
        ForwardInfo forwardInfo2 = new ForwardInfo("10.0.1.0", "0.0.0.0");
        ArrayList<ForwardInfo> infoList = new ArrayList<>(Arrays.asList(forwardInfo1,forwardInfo2));
        return infoList;
    }

    public List<ForwardInfo> getH421RoutingTable(){
        ForwardInfo forwardInfo1 = new ForwardInfo("0.0.0.0", "10.0.3.2");
        ForwardInfo forwardInfo2 = new ForwardInfo("10.0.3.0", "0.0.0.0");
        ArrayList<ForwardInfo> infoList = new ArrayList<>(Arrays.asList(forwardInfo1,forwardInfo2));
        return infoList;
    }

    public List<ForwardInfo> getH211RoutingTable(){
        ForwardInfo forwardInfo1 = new ForwardInfo("0.0.0.0", "10.0.11.2");
        ForwardInfo forwardInfo2 = new ForwardInfo("10.0.11.0", "0.0.0.0");
        ArrayList<ForwardInfo> infoList = new ArrayList<>(Arrays.asList(forwardInfo1,forwardInfo2));
        return infoList;
    }

    public List<ForwardInfo> getH221RoutingTable(){
        ForwardInfo forwardInfo1 = new ForwardInfo("0.0.0.0", "10.0.10.2");
        ForwardInfo forwardInfo2 = new ForwardInfo("10.0.10.0", "0.0.0.0");
        ArrayList<ForwardInfo> infoList = new ArrayList<>(Arrays.asList(forwardInfo1,forwardInfo2));
        return infoList;
    }

    public List<ForwardInfo> getR41RoutingTable(){
        ForwardInfo forwardInfo1 = new ForwardInfo("10.0.1.0", "0.0.0.0");
        ForwardInfo forwardInfo2 = new ForwardInfo("10.0.2.0", "0.0.0.0");
        ForwardInfo forwardInfo3 = new ForwardInfo("10.0.3.0", "10.0.2.2");
        ForwardInfo forwardInfo4 = new ForwardInfo("10.0.4.0", "10.0.2.2");
        ForwardInfo forwardInfo5 = new ForwardInfo("10.0.5.0", "0.0.0.0");
        ForwardInfo forwardInfo6 = new ForwardInfo("10.0.6.0", "10.0.5.2");
        ForwardInfo forwardInfo7 = new ForwardInfo("10.0.7.0", "10.0.5.2");
        ForwardInfo forwardInfo8 = new ForwardInfo("10.0.8.0", "10.0.5.2");
        ForwardInfo forwardInfo9 = new ForwardInfo("10.0.9.0", "10.0.5.2");
        ForwardInfo forwardInfo10 = new ForwardInfo("10.0.10.0", "10.0.5.2");
        ForwardInfo forwardInfo11 = new ForwardInfo("10.0.11.0", "10.0.5.2");
        ArrayList<ForwardInfo> infoList = new ArrayList<>(Arrays.asList(forwardInfo1,forwardInfo2,forwardInfo3,forwardInfo4,
                forwardInfo5,forwardInfo6,forwardInfo7,forwardInfo8,forwardInfo9,forwardInfo10,forwardInfo11));
        return infoList;
    }

    public List<ForwardInfo> getR42RoutingTable(){
        ForwardInfo forwardInfo1 = new ForwardInfo("10.0.1.0", "10.0.2.1");
        ForwardInfo forwardInfo2 = new ForwardInfo("10.0.2.0", "0.0.0.0");
        ForwardInfo forwardInfo3 = new ForwardInfo("10.0.3.0", "0.0.0.0");
        ForwardInfo forwardInfo4 = new ForwardInfo("10.0.4.0", "0.0.0.0");
        ForwardInfo forwardInfo5 = new ForwardInfo("10.0.5.0", "10.0.2.1");
        ForwardInfo forwardInfo6 = new ForwardInfo("10.0.6.0", "10.0.4.2");
        ForwardInfo forwardInfo7 = new ForwardInfo("10.0.7.0", "10.0.4.2");
        ForwardInfo forwardInfo8 = new ForwardInfo("10.0.8.0", "10.0.4.2");
        ForwardInfo forwardInfo9 = new ForwardInfo("10.0.9.0", "10.0.4.2");
        ForwardInfo forwardInfo10 = new ForwardInfo("10.0.10.0", "10.0.4.2");
        ForwardInfo forwardInfo11 = new ForwardInfo("10.0.11.0", "10.0.4.2");
        ArrayList<ForwardInfo> infoList = new ArrayList<>(Arrays.asList(forwardInfo1,forwardInfo2,forwardInfo3,forwardInfo4,
                forwardInfo5,forwardInfo6,forwardInfo7,forwardInfo8,forwardInfo9,forwardInfo10,forwardInfo11));
        return infoList;
    }

    public List<ForwardInfo> getR4RoutingTable(){
        ForwardInfo forwardInfo1 = new ForwardInfo("10.0.1.0", "10.0.5.1");
        ForwardInfo forwardInfo2 = new ForwardInfo("10.0.2.0", "10.0.5.1");
        ForwardInfo forwardInfo3 = new ForwardInfo("10.0.3.0", "10.0.4.1");
        ForwardInfo forwardInfo4 = new ForwardInfo("10.0.4.0", "0.0.0.0");
        ForwardInfo forwardInfo5 = new ForwardInfo("10.0.5.0", "0.0.0.0");
        ForwardInfo forwardInfo6 = new ForwardInfo("10.0.6.0", "0.0.0.0");
        ForwardInfo forwardInfo7 = new ForwardInfo("10.0.7.0", "10.0.6.2");
        ForwardInfo forwardInfo8 = new ForwardInfo("10.0.8.0", "10.0.6.2");
        ForwardInfo forwardInfo9 = new ForwardInfo("10.0.9.0", "10.0.6.2");
        ForwardInfo forwardInfo10 = new ForwardInfo("10.0.10.0","10.0.6.2");
        ForwardInfo forwardInfo11 = new ForwardInfo("10.0.11.0","10.0.6.2");
        ArrayList<ForwardInfo> infoList = new ArrayList<>(Arrays.asList(forwardInfo1,forwardInfo2,forwardInfo3,forwardInfo4,
                forwardInfo5,forwardInfo6,forwardInfo7,forwardInfo8,forwardInfo9,forwardInfo10,forwardInfo11));
        return infoList;
    }

    public List<ForwardInfo> getR2RoutingTable(){
        ForwardInfo forwardInfo1 = new ForwardInfo("10.0.1.0", "10.0.6.1");
        ForwardInfo forwardInfo2 = new ForwardInfo("10.0.2.0", "10.0.6.1");
        ForwardInfo forwardInfo3 = new ForwardInfo("10.0.3.0", "10.0.6.1");
        ForwardInfo forwardInfo4 = new ForwardInfo("10.0.4.0", "10.0.6.1");
        ForwardInfo forwardInfo5 = new ForwardInfo("10.0.5.0", "10.0.6.1");
        ForwardInfo forwardInfo6 = new ForwardInfo("10.0.6.0", "0.0.0.0");
        ForwardInfo forwardInfo7 = new ForwardInfo("10.0.7.0", "0.0.0.0");
        ForwardInfo forwardInfo8 = new ForwardInfo("10.0.8.0", "0.0.0.0");
        ForwardInfo forwardInfo9 = new ForwardInfo("10.0.9.0", "10.0.7.2");
        ForwardInfo forwardInfo10 = new ForwardInfo("10.0.10.0","10.0.8.2");
        ForwardInfo forwardInfo11 = new ForwardInfo("10.0.11.0","10.0.7.2");
        ArrayList<ForwardInfo> infoList = new ArrayList<>(Arrays.asList(forwardInfo1,forwardInfo2,forwardInfo3,forwardInfo4,
                forwardInfo5,forwardInfo6,forwardInfo7,forwardInfo8,forwardInfo9,forwardInfo10,forwardInfo11));
        return infoList;
    }

    public List<ForwardInfo> getR21RoutingTable(){
        ForwardInfo forwardInfo1 = new ForwardInfo("10.0.1.0", "10.0.7.1");
        ForwardInfo forwardInfo2 = new ForwardInfo("10.0.2.0", "10.0.7.1");
        ForwardInfo forwardInfo3 = new ForwardInfo("10.0.3.0", "10.0.7.1");
        ForwardInfo forwardInfo4 = new ForwardInfo("10.0.4.0", "10.0.7.1");
        ForwardInfo forwardInfo5 = new ForwardInfo("10.0.5.0", "10.0.7.1");
        ForwardInfo forwardInfo6 = new ForwardInfo("10.0.6.0", "10.0.7.1");
        ForwardInfo forwardInfo7 = new ForwardInfo("10.0.7.0", "0.0.0.0");
        ForwardInfo forwardInfo8 = new ForwardInfo("10.0.8.0", "10.0.7.1");
        ForwardInfo forwardInfo9 = new ForwardInfo("10.0.9.0", "0.0.0.0");
        ForwardInfo forwardInfo10 = new ForwardInfo("10.0.10.0","10.0.9.1");
        ForwardInfo forwardInfo11 = new ForwardInfo("10.0.11.0","0.0.0.0");
        ArrayList<ForwardInfo> infoList = new ArrayList<>(Arrays.asList(forwardInfo1,forwardInfo2,forwardInfo3,forwardInfo4,
                forwardInfo5,forwardInfo6,forwardInfo7,forwardInfo8,forwardInfo9,forwardInfo10,forwardInfo11));
        return infoList;
    }

    public List<ForwardInfo> getR22RoutingTable(){
        ForwardInfo forwardInfo1 = new ForwardInfo("10.0.1.0", "10.0.8.1");
        ForwardInfo forwardInfo2 = new ForwardInfo("10.0.2.0", "10.0.8.1");
        ForwardInfo forwardInfo3 = new ForwardInfo("10.0.3.0", "10.0.8.1");
        ForwardInfo forwardInfo4 = new ForwardInfo("10.0.4.0", "10.0.8.1");
        ForwardInfo forwardInfo5 = new ForwardInfo("10.0.5.0", "10.0.8.1");
        ForwardInfo forwardInfo6 = new ForwardInfo("10.0.6.0", "10.0.8.1");
        ForwardInfo forwardInfo7 = new ForwardInfo("10.0.7.0", "10.0.8.1");
        ForwardInfo forwardInfo8 = new ForwardInfo("10.0.8.0", "0.0.0.0");
        ForwardInfo forwardInfo9 = new ForwardInfo("10.0.9.0", "0.0.0.0");
        ForwardInfo forwardInfo10 = new ForwardInfo("10.0.10.0","0.0.0.0");
        ForwardInfo forwardInfo11 = new ForwardInfo("10.0.11.0","10.0.9.2");
        ArrayList<ForwardInfo> infoList = new ArrayList<>(Arrays.asList(forwardInfo1,forwardInfo2,forwardInfo3,forwardInfo4,
                forwardInfo5,forwardInfo6,forwardInfo7,forwardInfo8,forwardInfo9,forwardInfo10,forwardInfo11));
        return infoList;
    }


    //获取所有节点的路由表
    public Map<String,List<ForwardInfo>> getRoutingTable(){
        HashMap<String,List<ForwardInfo>> routingTable = new HashMap<>();
        routingTable.put("H411",getH411RoutingTable());
        routingTable.put("H421",getH421RoutingTable());
        routingTable.put("H211",getH211RoutingTable());
        routingTable.put("H221",getH221RoutingTable());

        routingTable.put("R41",getR41RoutingTable());
        routingTable.put("R42",getR42RoutingTable());
        routingTable.put("R4",getR4RoutingTable());
        routingTable.put("R21",getR21RoutingTable());
        routingTable.put("R22",getR22RoutingTable());
        routingTable.put("R2",getR2RoutingTable());
        return routingTable;
    }

}
