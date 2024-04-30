package com.Lantz2024.April;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Project: Algorithm20230913 - Pra07
 * <p>Powered by Lantz On 2024-04-07 12:11:55
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra07
 * @since 1.8
 */
public class Pra07 {
    public static void main(String[] args) {

    }
}

/**
 * 1600. ��λ�̳�˳��
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * һ��������ס�Ź��������ĺ����ǡ����������ǵȵȡ�ÿһ��ʱ��㣬�����ͥ�����˳���Ҳ����������
 *
 * ���������һ����ȷ�涨����λ�̳�˳�򣬵�һ�̳������ǹ����Լ������Ƕ���ݹ麯�� Successor(x, curOrder) ������һ���� x �͵�ǰ�ļ̳�˳��
 * �ú������� x ����һ�̳��ˡ�
 *
 * Successor(x, curOrder):
 *     ��� x û�к��ӻ������� x �ĺ��Ӷ��� curOrder �У�
 *         ��� x �ǹ�������ô���� null
 *         ���򣬷��� Successor(x �ĸ���, curOrder)
 *     ���򣬷��� x ���� curOrder �����곤�ĺ���
 * �ȷ�˵�����������ɹ��������ĺ��� Alice �� Bob ��Alice �� Bob �곤���� Alice �ĺ��� Jack ��ɡ�
 *
 * һ��ʼ�� curOrder Ϊ ["king"].
 * ���� Successor(king, curOrder) ������ Alice ���������ǽ� Alice ���� curOrder �У��õ� ["king", "Alice"] ��
 * ���� Successor(Alice, curOrder) ������ Jack ���������ǽ� Jack ���� curOrder �У��õ� ["king", "Alice", "Jack"] ��
 * ���� Successor(Jack, curOrder) ������ Bob ���������ǽ� Bob ���� curOrder �У��õ� ["king", "Alice", "Jack", "Bob"] ��
 * ���� Successor(Bob, curOrder) ������ null �����յõ��̳�˳��Ϊ ["king", "Alice", "Jack", "Bob"] ��
 * ͨ�����ϵĺ��������������ܵõ�һ��Ψһ�ļ̳�˳��
 *
 * ����ʵ�� ThroneInheritance �ࣺ
 *
 * ThroneInheritance(string kingName) ��ʼ��һ�� ThroneInheritance ��Ķ��󡣹�����������Ϊ���캯���Ĳ������롣
 * void birth(string parentName, string childName) ��ʾ parentName ��ӵ����һ����Ϊ childName �ĺ��ӡ�
 * void death(string name) ��ʾ��Ϊ name ����������һ���˵���������Ӱ�� Successor ������Ҳ����Ӱ�쵱ǰ�ļ̳�˳�������ֻ������˱��Ϊ����״̬��
 * string[] getInheritanceOrder() ���� ��ȥ ������Ա�ĵ�ǰ�̳�˳���б�
 *
 *
 * ʾ����
 *
 * ���룺
 * ["ThroneInheritance", "birth", "birth", "birth", "birth", "birth", "birth", "getInheritanceOrder", "death",
 * "getInheritanceOrder"]
 * [["king"], ["king", "andy"], ["king", "bob"], ["king", "catherine"], ["andy", "matthew"], ["bob", "alex"],
 * ["bob", "asha"], [null], ["bob"], [null]]
 * �����
 * [null, null, null, null, null, null, null, ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"], null,
 * ["king", "andy", "matthew", "alex", "asha", "catherine"]]
 *
 * ���ͣ�
 * ThroneInheritance t= new ThroneInheritance("king"); // �̳�˳��king
 * t.birth("king", "andy"); // �̳�˳��king > andy
 * t.birth("king", "bob"); // �̳�˳��king > andy > bob
 * t.birth("king", "catherine"); // �̳�˳��king > andy > bob > catherine
 * t.birth("andy", "matthew"); // �̳�˳��king > andy > matthew > bob > catherine
 * t.birth("bob", "alex"); // �̳�˳��king > andy > matthew > bob > alex > catherine
 * t.birth("bob", "asha"); // �̳�˳��king > andy > matthew > bob > alex > asha > catherine
 * t.getInheritanceOrder(); // ���� ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
 * t.death("bob"); // �̳�˳��king > andy > matthew > bob���Ѿ�ȥ����> alex > asha > catherine
 * t.getInheritanceOrder(); // ���� ["king", "andy", "matthew", "alex", "asha", "catherine"]
 *
 *
 * ��ʾ��
 *
 * 1 <= kingName.length, parentName.length, childName.length, name.length <= 15
 * kingName��parentName�� childName �� name ������СдӢ����ĸ��
 * ���еĲ��� childName �� kingName ������ͬ��
 * ���� death �����е��������� name Ҫô�ǹ�����Ҫô���Ѿ������˵���Ա���֡�
 * ÿ�ε��� birth(parentName, childName) ʱ��������������֤ parentName ��Ӧ����Ա�ǻ��ŵġ�
 * ������ 105 ��birth �� death ��
 * ������ 10 �� getInheritanceOrder ��
 */

class ThroneInheritance {
    class Node{
        String name;
        Node next;
        Node last; // ��¼���һ��
        boolean deleteName = false; // ��¼ɾ��������
        Node(String _name){
            name = _name;
        }
    }
    Map<String, Node> map = new HashMap<>();
    Node head = new Node(""), tail = new Node("");
    public ThroneInheritance(String kingName) {
        Node root = new Node(kingName);
        root.next = tail;
        head.next = root;
        map.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        Node node = new Node(childName);
        map.put(childName, node);
        Node p = map.get(parentName);
        Node tmp = p;
        while(tmp.last != null) tmp = tmp.last;
        node.next = tmp.next;
        tmp.next = node;
        p.last = node;
    }

    public void death(String name) {
        Node node = map.get(name);
        node.deleteName = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        Node tmp = head.next;
        while(tmp.next != null) {
            if(!tmp.deleteName) ans.add(tmp.name);
            tmp = tmp.next;
        }
        return ans;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
