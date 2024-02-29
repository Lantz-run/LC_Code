package com.Lantz2024.January;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra04
 * <p>Powered by Lantz On 2024-01-17 12:27:29
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra04
 * @since 1.8
 */
public class Pra04 {
    public static void main(String[] args) {

    }
}

/**
 * 22. ��������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺n = 3
 * �����["((()))","(()())","(())()","()(())","()()()"]
 * ʾ�� 2��
 *
 * ���룺n = 1
 * �����["()"]
 */
class Solution04 {
    private int n;
    private char[] path;
    private final List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        this.n = n;
        path = new char[n * 2];
        dfs(0, 0);
        return ans;
    }
    public void dfs(int i, int open){ // open�������ŵ���Ŀ
        if(i == n * 2){ // �߽���������i����2nʱ, �����ַ���
            ans.add(new String(path));
            return;
        }
        if(open < n){ // ������
            path[i] = '(';
            dfs(i+1, open+1);
        }
        if(i-open < open){ // ������С�������ŵ���Ŀ����ѡ������
            path[i] = ')';
            dfs(i+1, open);
        }
    }
}