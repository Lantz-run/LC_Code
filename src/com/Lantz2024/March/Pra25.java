package com.Lantz2024.March;

import java.util.LinkedList;

/**
 * <p>Project: Algorithm20230913 - Pra25
 * <p>Powered by Lantz On 2024-03-31 14:59:30
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra25
 * @since 1.8
 */
public class Pra25 {

}

/**
 * 331. ��֤��������ǰ�����л�
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ���л���������һ�ַ�����ʹ�� ǰ����� ������������һ���ǿսڵ�ʱ�����ǿ��Լ�¼������ڵ��ֵ���������һ���սڵ㣬���ǿ���ʹ��һ�����ֵ��¼������ #��
 *
 *
 *
 * ���磬����Ķ��������Ա����л�Ϊ�ַ��� "9,3,4,#,#,1,#,#,2,#,6,#,#"������ # ����һ���սڵ㡣
 *
 * ����һ���Զ��ŷָ������У���֤���Ƿ�����ȷ�Ķ�������ǰ�����л�����дһ���ڲ��ع����������µĿ����㷨��
 *
 * ��֤ ÿ���Զ��ŷָ����ַ���Ϊһ��������Ϊһ����ʾ null ָ��� '#' ��
 *
 * �������Ϊ�����ʽ������Ч��
 *
 * ��������Զ����������������Ķ��ţ����� "1,,3" ��
 * ע�⣺�������ؽ�����
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * ���: true
 * ʾ�� 2:
 *
 * ����: preorder = "1,#"
 * ���: false
 * ʾ�� 3:
 *
 * ����: preorder = "9,#,#,1"
 * ���: false
 *
 *
 * ��ʾ:
 *
 * 1 <= preorder.length <= 104
 * preorder ���Զ��� ������ �ָ��� [0,100] ��Χ�ڵ������� ��#�� ���
 */

class Solution25 {
    public boolean isValidSerialization(String preorder) {
        // ����������Ⱥͳ���
        String[] nodes = preorder.split(",");
        int diff = 1;
        for(String node : nodes){
            diff--;
            if(diff < 0){
                return false;
            }
            if(!node.equals("#")){
                diff += 2;
            }
        }
        return diff == 0;
    }
}

/**
 * �����룺 "9,3,4,#,#,1,#,#,2,#,6,#,#"?�������� x,#,# ��ʱ�򣬾Ͱ�����Ϊ #��
 *
 * ģ��һ����̣�
 *
 * [9,3,4,#,#] => [9,3,#]������
 * [9,3,#,1,#,#] => [9,3,#,#] => [9,#] ������
 * [9,#2,#,6,#,#] => [9,#,2,#,#] => [9,#,#] => [#]������
 *
 */
class Solution25_1 {
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> stack = new LinkedList<>();
        for(String node : preorder.split(",")){
            stack.push(node);
            while(stack.size() >= 3 && stack.get(0).equals("#")
                    && stack.get(1).equals("#")
                    && !stack.get(2).equals("#")){
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }
}
