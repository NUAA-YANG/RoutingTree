package vnp;

import entity.ForwardInfo;
import entity.Node;

import java.util.*;

/**
 * @Author YZX
 * @Create 2023-09-27 17:04
 * @Java-version jdk1.8
 */
public class CreateRoutingTree {


    public static void main(String[] args) {
        CreateRoutingTree routingTree = new CreateRoutingTree();
        List<List<String>> tree = routingTree.getRoutingTree("H411");
        tree.forEach(x-> System.out.println(x));
    }

    //根据节点名称获取该节点对应的路由树
    public List<List<String>> getRoutingTree(String hostName){
        List<List<String>> routingTree = new ArrayList<>();
        CreateEnv createEnv = new CreateEnv();
        //获取所有主机节点
        HashMap<String, Node> hostMap = createEnv.getHostMap();
        //获取路由节点
        HashMap<String, Node> routerMap = createEnv.getRouterMap();
        //获取所有的路由表
        Map<String, List<ForwardInfo>> routingTable = createEnv.getRoutingTable();
        //搜索主机对应的网关及路由表
        if (!hostName.startsWith("H")){
            throw new RuntimeException("请输入开头为H表示的主机节点");
        }else if (!hostMap.containsKey(hostName)){
            throw new RuntimeException("路由表中无名称为"+hostName+"的主机");
        }else {
            //比如H411获取的就是 10.0.11.1
            String nextGateway = null;
            String tempGateway = null;
            //获取主机下一跳网关
            List<ForwardInfo> hostRoutingTable = routingTable.get(hostName);
            for (ForwardInfo nextInfo:hostRoutingTable){
                if (nextInfo.getDestination().equals("0.0.0.0")){
                    nextGateway = nextInfo.getGateway();
                    tempGateway = nextGateway;
                }
            }
            //排除源主机生成目的主机IP和网关
            hostMap.remove(hostName);
            //存储目的主机节点
            HashMap<String, Node> destHostMap = new HashMap<>(hostMap);
            //存储目的IP地址和目的网关地址
            List<String> ipList = new ArrayList<>();
            List<String> destGatewayList = new ArrayList<>();
            for (Map.Entry<String, Node> entry : destHostMap.entrySet()){
                String ip = entry.getValue().getInterfaceList().get(0);
                ipList.add(ip);
                destGatewayList.add(getGatewayByIp(ip));
            }
            //开始遍历每一个目的节点
            for (String dest:destGatewayList){
                //单次路径，先添加源主机名称
                List<String> path = new ArrayList<>(Arrays.asList(hostName));
                //下一跳不是目的IP地址
                while (!ipList.contains(nextGateway)){
                    //前往下一跳路由器
                    Node nextNode = getNodeByInterface(nextGateway, routerMap);
                    //添加进入路径
                    path.add(nextNode.getName());
                    //获取路由器对应的路由表
                    List<ForwardInfo> nextNodeRoutingTable = routingTable.get(nextNode.getName());
                    //根据目的IP找到下一跳网关
                    nextGateway = getGatewayByDest(dest, nextNodeRoutingTable);
                    if (nextGateway.equals("0.0.0.0")){
                        break;
                    }
                }
                //判断是到了哪一个目的节点
                Node destNode = getNodeByGateway(dest, hostMap);
                path.add(destNode.getName());
                routingTree.add(path);
                //又再次回到直连的路由器
                nextGateway = tempGateway;
            }
        }
        return routingTree;
    }




    //根据IP地址获得网关
    public String getGatewayByIp(String ip){
        String[] parts = ip.split("\\.");
        parts[3] = "0";
        String gateway = String.join(".", parts);
        return gateway;
    }


    //根据掩码名称获取对应的节点
    public Node getNodeByGateway(String gateway,HashMap<String, Node> nodeMap){
        //获取所有路由器名称
        Set<String> routerNameSet = nodeMap.keySet();
        for (String name:routerNameSet){
            //获得每一个路由节点
            Node node = nodeMap.get(name);
            //路由节点的接口集合
            List<String> interfaceList = node.getInterfaceList();
            //接口比较
            for (String inter:interfaceList){
                String[] splitInter = inter.split("\\.");
                String[] splitGateway = gateway.split("\\.");
                if (splitInter[0].equals(splitGateway[0])
                        && splitInter[1].equals(splitGateway[1])
                        && splitInter[2].equals(splitGateway[2])){
                    return node;
                }
            }
        }
        return null;
    }


    //根据网关名称找到对应的节点
    public Node getNodeByInterface(String interfaceIp,HashMap<String, Node> nodeMap){
        //获取所有路由器名称
        Set<String> routerNameSet = nodeMap.keySet();
        for (String name:routerNameSet){
            //获得每一个路由节点
            Node node = nodeMap.get(name);
            //路由节点的接口集合
            List<String> interfaceList = node.getInterfaceList();
            //接口比较
            for (String inter:interfaceList){
                if (interfaceIp.equals(inter)){
                    return node;
                }
            }
        }
        return null;
    }

    //根据目的IP找到下一跳网关
    public String getGatewayByDest(String dest , List<ForwardInfo> routingTable){
        for (ForwardInfo info:routingTable){
            if (info.getDestination().equals(dest)){
                return info.getGateway();
            }
        }
        return null;
    }

}
